package com.dingjiaxiong.circle.server.sensitive;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingjiaxiong.circle.api.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.circle.server.entity.po.SensitiveWords;
import com.dingjiaxiong.circle.server.service.SensitiveWordsService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 词库上下文环境
 * <p>
 * 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 *
 * @author minghu.zhang
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Slf4j
public class WordContext {

    /**
     * 敏感词字典
     */
    private final Map wordMap = new HashMap(1024);

    /**
     * 是否已初始化
     */
    private boolean init;

    private long addLastId;

    public WordContext(boolean autoLoad, SensitiveWordsService service) {
        clearDelData(service);
        Set<String> black = new HashSet<>();
        Set<String> white = new HashSet<>();
        List<SensitiveWords> list = service.list(Wrappers.<SensitiveWords>lambdaQuery().eq(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode()));
        for (SensitiveWords words : list) {
            if (words.getType() == 1) {
                black.add(words.getWords());
            } else {
                white.add(words.getWords());
            }
        }
        if (CollectionUtils.isNotEmpty(list)) {
            this.addLastId = list.get(list.size() - 1).getId();
        }
        initKeyWord(black, white);
        if (autoLoad) {
            reloadWord(service);
        }
    }

    private void clearDelData(SensitiveWordsService service) {
        LambdaUpdateWrapper<SensitiveWords> remove = Wrappers.<SensitiveWords>lambdaUpdate().eq(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode());
        service.remove(remove);
    }

    private void reloadWord(SensitiveWordsService service) {

        // 创建一个单线程的定时线程池
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        // 创建一个Runnable任务
        Runnable task = () -> {
            try {
                addNewWords(service);
                removeDelWords(service);
            } catch (Exception e) {
                log.error("Sensitive words task error", e);
            }
        };
        // 定时执行任务，初始延迟0，之后每分钟执行一次
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);

    }

    private void removeDelWords(SensitiveWordsService service) {
        LambdaUpdateWrapper<SensitiveWords> query = Wrappers.<SensitiveWords>lambdaUpdate()
                .eq(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode());
        List<SensitiveWords> list = service.list(query);
        if (CollectionUtils.isNotEmpty(list)) {
            log.info("removeDelWords {}", JSON.toJSON(list));
            Set<String> black = new HashSet<>();
            Set<String> white = new HashSet<>();
            for (SensitiveWords words : list) {
                if (words.getType() == 1) {
                    black.add(words.getWords());
                } else {
                    white.add(words.getWords());
                }
            }
            removeWord(black, WordType.BLACK);
            removeWord(white, WordType.WHITE);
        }
    }

    private void addNewWords(SensitiveWordsService service) {
        LambdaUpdateWrapper<SensitiveWords> query = Wrappers.<SensitiveWords>lambdaUpdate()
                .gt(SensitiveWords::getId, addLastId)
                .eq(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SensitiveWords> list = service.list(query);
        if (CollectionUtils.isNotEmpty(list)) {
            log.info("addNewWords {}", JSON.toJSON(list));
            this.addLastId = list.get(list.size() - 1).getId();
            Set<String> black = new HashSet<>();
            Set<String> white = new HashSet<>();
            for (SensitiveWords words : list) {
                if (words.getType() == 1) {
                    black.add(words.getWords());
                } else {
                    white.add(words.getWords());
                }
            }
            addWord(black, WordType.BLACK);
            addWord(white, WordType.WHITE);
        }
    }

    /**
     * 获取初始化的敏感词列表
     *
     * @return 敏感词列表
     */
    public Map getWordMap() {
        return wordMap;
    }

    /**
     * 初始化
     */
    private synchronized void initKeyWord(Set<String> black, Set<String> white) {
        try {
            if (!init) {
                // 将敏感词库加入到HashMap中
                addWord(black, WordType.BLACK);
                // 将非敏感词库也加入到HashMap中
                addWord(white, WordType.WHITE);
            }
            init = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
     * 中 = { isEnd = 0 国 = {<br>
     * isEnd = 1 人 = {isEnd = 0 民 = {isEnd = 1} } 男 = { isEnd = 0 人 = { isEnd = 1 }
     * } } } 五 = { isEnd = 0 星 = { isEnd = 0 红 = { isEnd = 0 旗 = { isEnd = 1 } } } }
     */
    public void addWord(Collection<String> wordList, WordType wordType) {
        if (CollectionUtils.isEmpty(wordList)) {
            return;
        }
        Map nowMap;
        Map<String, String> newWorMap;
        // 迭代keyWordSet
        for (String key : wordList) {
            nowMap = wordMap;
            for (int i = 0; i < key.length(); i++) {
                // 转换成char型
                char keyChar = key.charAt(i);
                // 获取
                Object wordMap = nowMap.get(keyChar);
                // 如果存在该key，直接赋值
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    // 不存在则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<>(4);
                    // 不是最后一个
                    newWorMap.put("isEnd", String.valueOf(EndType.HAS_NEXT.ordinal()));
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    // 最后一个
                    nowMap.put("isEnd", String.valueOf(EndType.IS_END.ordinal()));
                    nowMap.put("isWhiteWord", String.valueOf(wordType.ordinal()));
                }
            }
        }
    }

    /**
     * 在线删除敏感词
     *
     * @param wordList 敏感词列表
     * @param wordType 黑名单 BLACk，白名单WHITE
     */
    public void removeWord(Collection<String> wordList, WordType wordType) {
        if (CollectionUtils.isEmpty(wordList)) {
            return;
        }
        Map nowMap;
        for (String key : wordList) {
            List<Map> cacheList = new ArrayList<>();
            nowMap = wordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);

                Object map = nowMap.get(keyChar);
                if (map != null) {
                    nowMap = (Map) map;
                    cacheList.add(nowMap);
                } else {
                    return;
                }

                if (i == key.length() - 1) {
                    char[] keys = key.toCharArray();
                    boolean cleanable = false;
                    char lastChar = 0;
                    for (int j = cacheList.size() - 1; j >= 0; j--) {
                        Map cacheMap = cacheList.get(j);
                        if (j == cacheList.size() - 1) {
                            if (String.valueOf(WordType.BLACK.ordinal()).equals(cacheMap.get("isWhiteWord"))) {
                                if (wordType == WordType.WHITE) {
                                    return;
                                }
                            }
                            if (String.valueOf(WordType.WHITE.ordinal()).equals(cacheMap.get("isWhiteWord"))) {
                                if (wordType == WordType.BLACK) {
                                    return;
                                }
                            }
                            cacheMap.remove("isWhiteWord");
                            cacheMap.remove("isEnd");
                            if (cacheMap.size() == 0) {
                                cleanable = true;
                                continue;
                            }
                        }
                        if (cleanable) {
                            Object isEnd = cacheMap.get("isEnd");
                            if (String.valueOf(EndType.IS_END.ordinal()).equals(isEnd)) {
                                cleanable = false;
                            }
                            cacheMap.remove(lastChar);
                        }
                        lastChar = keys[j];
                    }

                    if (cleanable) {
                        wordMap.remove(lastChar);
                    }
                }
            }
        }
    }

}

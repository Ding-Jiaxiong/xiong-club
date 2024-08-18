package com.dingjiaxiong.circle.server.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingjiaxiong.auth.entity.Result;
import com.dingjiaxiong.circle.api.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.circle.server.entity.po.SensitiveWords;
import com.dingjiaxiong.circle.server.service.SensitiveWordsService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 圈子信息 前端控制器
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
@Slf4j
@RestController
@RequestMapping("/circle/sensitive/words")
public class SensitiveWordsController {

    @Resource
    private SensitiveWordsService sensitiveWordsService;

    /**
     * 新增敏感词
     */
    @GetMapping(value = "/save")
    public Result<Boolean> save(String words, Integer type) {
        try {
            if (log.isInfoEnabled()) {
                log.info("新增敏感词入参{}", words);
            }
            Preconditions.checkArgument(StringUtils.isNotBlank(words), "参数不能为空！");
            SensitiveWords data = new SensitiveWords();
            data.setType(type);
            data.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            data.setWords(words);
            return Result.ok(sensitiveWordsService.save(data));
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("新增敏感词异常！错误原因{}", e.getMessage(), e);
            return Result.fail("新增敏感词异常！");
        }
    }

    /**
     * 删除敏感词
     */
    @GetMapping(value = "/remove")
    public Result<Boolean> remove(Long id) {
        try {
            if (log.isInfoEnabled()) {
                log.info("删除敏感词入参{}", id);
            }
            Preconditions.checkArgument(Objects.nonNull(id), "参数不能为空！");
            LambdaUpdateWrapper<SensitiveWords> update = Wrappers.<SensitiveWords>lambdaUpdate().set(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode())
                    .eq(SensitiveWords::getId, id).eq(SensitiveWords::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
            return Result.ok(sensitiveWordsService.update(update));
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("删除敏感词异常！错误原因{}", e.getMessage(), e);
            return Result.fail("删除敏感词异常！");
        }
    }

}

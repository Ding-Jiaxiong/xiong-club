package com.dingjiaxiong.circle.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.circle.server.dao.SensitiveWordsMapper;
import com.dingjiaxiong.circle.server.entity.po.SensitiveWords;
import com.dingjiaxiong.circle.server.service.SensitiveWordsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 敏感词表 服务实现类
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/17
 */
@Service
public class SensitiveWordsServiceImpl extends ServiceImpl<SensitiveWordsMapper, SensitiveWords> implements SensitiveWordsService {

}

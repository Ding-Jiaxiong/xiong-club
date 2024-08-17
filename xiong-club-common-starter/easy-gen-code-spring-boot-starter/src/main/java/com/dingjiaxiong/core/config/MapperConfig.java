package com.dingjiaxiong.core.config;

import com.dingjiaxiong.core.entity.Mapper;
import lombok.Data;

import java.util.List;

/**
 * 模板与生成文件的映射关系
 *
 * @author loser
 * @date 2023/9/4
 */
@Data
public class MapperConfig {

    /**
     * 文件生成到该项目的哪个模块
     */
    private String module;

    /**
     * 映射关系
     */
    private List<Mapper> mappers;

}

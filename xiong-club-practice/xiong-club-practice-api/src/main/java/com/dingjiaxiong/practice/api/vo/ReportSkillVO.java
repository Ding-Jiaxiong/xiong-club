package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ReportSkillVO implements Serializable {

    /**
     * 分数
     */
    private BigDecimal star;

    /**
     * 名称
     */
    private String name;

}
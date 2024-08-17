package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SubjectRadioPO implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * a,b,c,d
     */
    private Integer optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;

    private Integer isDeleted;
    /**
     * 更新时间
     */
    private Date updateTime;

}
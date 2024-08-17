package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SubjectMappingPO implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 标签id
     */
    private Long labelId;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;
    
    private Integer isDeleted;


}

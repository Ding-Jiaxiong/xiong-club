package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PracticePO  implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 完成情况 1完成 0未完成
     */
    private Integer completeStatus;

    /**
     * 所用时间
     */
    private String timeUse;

    /**
     * 交卷时间
     */
    private Date submitTime;

    /**
     * 正确率
     */
    private BigDecimal correctRate;

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
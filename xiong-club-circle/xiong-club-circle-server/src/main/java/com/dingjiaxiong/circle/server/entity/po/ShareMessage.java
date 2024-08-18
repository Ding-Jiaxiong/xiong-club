package com.dingjiaxiong.circle.server.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/18
 */
@Getter
@Setter
@TableName("share_message")
public class ShareMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 来自人
     */
    private String fromId;

    /**
     * 送达人
     */
    private String toId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 是否被阅读 1是 2否
     */
    private Integer isRead;

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

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否被删除 0为删除 1已删除
     */
    private Integer isDeleted;
}

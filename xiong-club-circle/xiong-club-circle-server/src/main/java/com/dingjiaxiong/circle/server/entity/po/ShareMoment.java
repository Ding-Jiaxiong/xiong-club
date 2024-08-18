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
 * 动态信息
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
@Getter
@Setter
@TableName("share_moment")
public class ShareMoment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动态ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 圈子ID
     */
    private Long circleId;

    /**
     * 动态内容
     */
    private String content;

    /**
     * 动态图片内容
     */
    private String picUrls;

    /**
     * 回复数
     */
    private Integer replyCount;

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

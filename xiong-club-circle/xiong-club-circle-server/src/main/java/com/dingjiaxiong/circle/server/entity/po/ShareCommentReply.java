package com.dingjiaxiong.circle.server.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dingjiaxiong.circle.api.common.TreeNode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论及回复信息
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
@Getter
@Setter
@TableName("share_comment_reply")
public class ShareCommentReply extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 原始动态ID
     */
    private Long momentId;

    /**
     * 回复类型 1评论 2回复
     */
    private Integer replyType;

    /**
     * 评论目标id
     */
    private Long toId;

    /**
     * 评论人
     */
    private String toUser;

    /**
     * 评论人是否作者 1=是 0=否
     */
    private Integer toUserAuthor;

    /**
     * 回复目标id
     */
    private Long replyId;

    /**
     * 回复人
     */
    private String replyUser;

    /**
     * 回复人是否作者 1=是 0=否
     */
    private Integer replayAuthor;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片内容
     */
    private String picUrls;

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

    private Long parentId;

    @Override
    public Long getNodeId() {
        return id;
    }

    @Override
    public Long getNodePId() {
        return parentId;
    }

}

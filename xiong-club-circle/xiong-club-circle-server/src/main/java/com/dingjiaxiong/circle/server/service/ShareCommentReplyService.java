package com.dingjiaxiong.circle.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.circle.api.req.GetShareCommentReq;
import com.dingjiaxiong.circle.api.req.RemoveShareCommentReq;
import com.dingjiaxiong.circle.api.req.SaveShareCommentReplyReq;
import com.dingjiaxiong.circle.api.vo.ShareCommentReplyVO;
import com.dingjiaxiong.circle.server.entity.po.ShareCommentReply;

import java.util.List;

/**
 * <p>
 * 评论及回复信息 服务类
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
public interface ShareCommentReplyService extends IService<ShareCommentReply> {

    Boolean saveComment(SaveShareCommentReplyReq req);

    Boolean removeComment(RemoveShareCommentReq req);

    List<ShareCommentReplyVO> listComment(GetShareCommentReq req);

}

package com.dingjiaxiong.circle.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.circle.api.common.PageResult;
import com.dingjiaxiong.circle.api.req.GetShareMomentReq;
import com.dingjiaxiong.circle.api.req.RemoveShareMomentReq;
import com.dingjiaxiong.circle.api.req.SaveMomentCircleReq;
import com.dingjiaxiong.circle.api.vo.ShareMomentVO;
import com.dingjiaxiong.circle.server.entity.po.ShareMoment;

/**
 * <p>
 * 动态信息 服务类
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
public interface ShareMomentService extends IService<ShareMoment> {

    Boolean saveMoment(SaveMomentCircleReq req);

    PageResult<ShareMomentVO> getMoments(GetShareMomentReq req);

    Boolean removeMoment(RemoveShareMomentReq req);

    void incrReplyCount(Long id, int count);

}

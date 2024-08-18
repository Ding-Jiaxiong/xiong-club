package com.dingjiaxiong.circle.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.circle.api.req.RemoveShareCircleReq;
import com.dingjiaxiong.circle.api.req.SaveShareCircleReq;
import com.dingjiaxiong.circle.api.req.UpdateShareCircleReq;
import com.dingjiaxiong.circle.api.vo.ShareCircleVO;
import com.dingjiaxiong.circle.server.entity.po.ShareCircle;

import java.util.List;

/**
 * <p>
 * 圈子信息 服务类
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
public interface ShareCircleService extends IService<ShareCircle> {

    Boolean saveCircle(SaveShareCircleReq req);

    Boolean updateCircle(UpdateShareCircleReq req);


    Boolean removeCircle(RemoveShareCircleReq req);

    List<ShareCircleVO> listResult();


}

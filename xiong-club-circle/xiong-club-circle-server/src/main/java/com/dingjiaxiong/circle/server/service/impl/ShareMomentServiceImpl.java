package com.dingjiaxiong.circle.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.circle.api.common.PageInfo;
import com.dingjiaxiong.circle.api.common.PageResult;
import com.dingjiaxiong.circle.api.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.circle.api.req.GetShareMomentReq;
import com.dingjiaxiong.circle.api.req.RemoveShareMomentReq;
import com.dingjiaxiong.circle.api.req.SaveMomentCircleReq;
import com.dingjiaxiong.circle.api.vo.ShareMomentVO;
import com.dingjiaxiong.circle.server.dao.ShareCommentReplyMapper;
import com.dingjiaxiong.circle.server.dao.ShareMomentMapper;
import com.dingjiaxiong.circle.server.entity.dto.UserInfo;
import com.dingjiaxiong.circle.server.entity.po.ShareCommentReply;
import com.dingjiaxiong.circle.server.entity.po.ShareMoment;
import com.dingjiaxiong.circle.server.rpc.UserRpc;
import com.dingjiaxiong.circle.server.service.ShareMomentService;
import com.dingjiaxiong.circle.server.util.LoginUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 动态信息 服务实现类
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/16
 */
@Service
public class ShareMomentServiceImpl extends ServiceImpl<ShareMomentMapper, ShareMoment> implements ShareMomentService {

    @Resource
    private UserRpc userRpc;

    @Resource
    private ShareCommentReplyMapper shareCommentReplyMapper;

    @Override
    public Boolean saveMoment(SaveMomentCircleReq req) {

        ShareMoment moment = new ShareMoment();
        moment.setCircleId(req.getCircleId());
        moment.setContent(req.getContent());
        if (!CollectionUtils.isEmpty(req.getPicUrlList())) {
            moment.setPicUrls(JSON.toJSONString(req.getPicUrlList()));
        }
        moment.setReplyCount(0);
        moment.setCreatedBy(LoginUtil.getLoginId());
        moment.setCreatedTime(new Date());
        moment.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        return super.save(moment);

    }

    @Override
    public PageResult<ShareMomentVO> getMoments(GetShareMomentReq req) {

        LambdaQueryWrapper<ShareMoment> query = Wrappers.<ShareMoment>lambdaQuery()
                .eq(Objects.nonNull(req.getCircleId()), ShareMoment::getCircleId, req.getCircleId())
                .eq(ShareMoment::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode())
                .orderByDesc(ShareMoment::getCircleId);
        PageInfo pageInfo = req.getPageInfo();
        Page<ShareMoment> page = new Page<>(pageInfo.getPageNo(), pageInfo.getPageSize());
        Page<ShareMoment> pageRes = super.page(page, query);
        PageResult<ShareMomentVO> result = new PageResult<>();
        List<ShareMoment> records = pageRes.getRecords();
        List<String> userNameList = records.stream().map(ShareMoment::getCreatedBy).distinct().collect(Collectors.toList());
        Map<String, UserInfo> userInfoMap = userRpc.batchGetUserInfo(userNameList);
        UserInfo defaultUser = new UserInfo();
        List<ShareMomentVO> list = records.stream().map(item -> {
            ShareMomentVO vo = new ShareMomentVO();
            vo.setId(item.getId());
            vo.setCircleId(item.getCircleId());
            vo.setContent(item.getContent());
            if (Objects.nonNull(item.getPicUrls())) {
                List<String> picList = JSONArray.parseArray(item.getPicUrls(), String.class);
                vo.setPicUrlList(picList);
            }
            vo.setReplyCount(item.getReplyCount());
            vo.setCreatedTime(item.getCreatedTime().getTime());
            UserInfo user = userInfoMap.getOrDefault(item.getCreatedBy(), defaultUser);
            vo.setUserName(user.getNickName());
            vo.setUserAvatar(user.getAvatar());
            return vo;
        }).collect(Collectors.toList());
        result.setRecords(list);
        result.setTotal((int) pageRes.getTotal());
        result.setPageSize(pageInfo.getPageSize());
        result.setPageNo(pageInfo.getPageNo());
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeMoment(RemoveShareMomentReq req) {
        ShareCommentReply updateEntity = new ShareCommentReply();
        updateEntity.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        LambdaUpdateWrapper<ShareCommentReply> update = Wrappers.<ShareCommentReply>lambdaUpdate().eq(ShareCommentReply::getMomentId, req.getId());
        shareCommentReplyMapper.update(updateEntity, update);
        return super.update(Wrappers.<ShareMoment>lambdaUpdate().eq(ShareMoment::getId, req.getId())
                .eq(ShareMoment::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode())
                .set(ShareMoment::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode()));
    }

    @Override
    public void incrReplyCount(Long id, int count) {
        getBaseMapper().incrReplyCount(id, count);
    }

}

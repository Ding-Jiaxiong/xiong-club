package com.dingjiaxiong.practice.server.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.practice.api.common.Result;
import com.dingjiaxiong.practice.api.req.SubmitPracticeDetailReq;
import com.dingjiaxiong.practice.api.req.SubmitSubjectDetailReq;
import com.dingjiaxiong.practice.server.service.PracticeDetailService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/practice/detail")
public class PracticeDetailController {

    @Resource
    private PracticeDetailService practiceDetailService;

    /**
     * 提交练题情况
     */
    @PostMapping(value = "/submit")
    public Result<Boolean> submit(@RequestBody SubmitPracticeDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("提交练题情况入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSetId()), "套题id不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getSubmitTime()), "交卷时间不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getTimeUse()), "用时不能为空！");
            Boolean result = practiceDetailService.submit(req);
            if (log.isInfoEnabled()) {
                log.info("提交练题情况出参{}", JSON.toJSONString(result));
            }
            return Result.ok(result);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("提交练题情况异常！错误原因{}", e.getMessage(), e);
            return Result.fail("提交练题情况异常！");
        }
    }

}
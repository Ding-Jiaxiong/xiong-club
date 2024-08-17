package com.dingjiaxiong.practice.server.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.practice.api.common.Result;
import com.dingjiaxiong.practice.api.req.*;
import com.dingjiaxiong.practice.api.vo.ReportVO;
import com.dingjiaxiong.practice.api.vo.ScoreDetailVO;
import com.dingjiaxiong.practice.api.vo.SubjectDetailVO;
import com.dingjiaxiong.practice.server.service.PracticeDetailService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/practice/detail")
public class PracticeDetailController {

    @Resource
    private PracticeDetailService practiceDetailService;

    /**
     * 提交题目
     */
    @PostMapping(value = "/submitSubject")
    public Result<Boolean> submitSubject(@RequestBody SubmitSubjectDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("练习提交题目入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getPracticeId()), "练习id不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectId()), "题目id不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectType()), "题目类型不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getTimeUse()), "用时不能为空！");
            Boolean result = practiceDetailService.submitSubject(req);
            log.info("练习提交题目出参{}", result);
            return Result.ok(result);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("练习提交题目异常！错误原因{}", e.getMessage(), e);
            return Result.fail("练习提交题目异常！");
        }
    }


    /**
     * 提交练题情况【交卷】
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

    /**
     * 答案解析-每题得分
     */
    @PostMapping(value = "/getScoreDetail")
    public Result<List<ScoreDetailVO>> getScoreDetail(@RequestBody GetScoreDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("每题得分入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getPracticeId()), "练习id不能为空！");
            List<ScoreDetailVO> list = practiceDetailService.getScoreDetail(req);
            if (log.isInfoEnabled()) {
                log.info("每题得分出参{}", JSON.toJSONString(list));
            }
            return Result.ok(list);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("每题得分异常！错误原因{}", e.getMessage(), e);
            return Result.fail("每题得分异常！");
        }
    }

    /**
     * 答案解析-答题详情
     */
    @PostMapping(value = "/getSubjectDetail")
    public Result<SubjectDetailVO> getSubjectDetail(@RequestBody GetSubjectDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("答案详情入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectId()), "题目id不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectType()), "题目类型不能为空！");
            SubjectDetailVO subjectDetailVO = practiceDetailService.getSubjectDetail(req);
            if (log.isInfoEnabled()) {
                log.info("答案详情出参{}", JSON.toJSONString(subjectDetailVO));
            }
            return Result.ok(subjectDetailVO);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("答案详情异常！错误原因{}", e.getMessage(), e);
            return Result.fail("答案详情异常！");
        }
    }

    /**
     * 答案解析-评估报告
     */
    @PostMapping(value = "/getReport")
    public Result<ReportVO> getReport(@RequestBody GetReportReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("获取评估报告入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getPracticeId()), "练习id不能为空！");
            ReportVO reportVO = practiceDetailService.getReport(req);
            if (log.isInfoEnabled()) {
                log.info("获取评估报告出参{}", JSON.toJSONString(reportVO));
            }
            return Result.ok(reportVO);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("获取评估报告异常！错误原因{}", e.getMessage(), e);
            return Result.fail("获取评估报告异常！");
        }
    }

}
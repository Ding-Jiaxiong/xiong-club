package com.dingjiaxiong.practice.api.req;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetPracticeSubjectListReq implements Serializable {

    /**
     * 分类与标签组合的ids
     */
    private List<String> assembleIds;

}

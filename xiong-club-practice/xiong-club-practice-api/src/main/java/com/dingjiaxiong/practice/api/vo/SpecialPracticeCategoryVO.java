package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpecialPracticeCategoryVO implements Serializable {

    private String categoryName;

    private Long categoryId;

    private List<SpecialPracticeLabelVO> labelList;

}

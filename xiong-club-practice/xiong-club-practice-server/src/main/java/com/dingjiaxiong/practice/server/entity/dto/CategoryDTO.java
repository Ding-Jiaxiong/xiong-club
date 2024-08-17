package com.dingjiaxiong.practice.server.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private List<Integer> subjectTypeList;

    private Integer categoryType;

    private Long parentId;

}

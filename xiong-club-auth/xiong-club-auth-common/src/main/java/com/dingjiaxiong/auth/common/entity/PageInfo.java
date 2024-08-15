package com.dingjiaxiong.auth.common.entity;

/**
 * 分页请求实体
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/5
 */
public class PageInfo {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}

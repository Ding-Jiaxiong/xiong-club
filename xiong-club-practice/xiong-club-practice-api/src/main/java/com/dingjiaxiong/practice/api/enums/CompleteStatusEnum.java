package com.dingjiaxiong.practice.api.enums;

public enum CompleteStatusEnum {

    /**
     * 未完成
     */
    NO_COMPLETE(0, "未完成"),

    /**
     * 已完成
     */
    COMPLETE(1, "已完成");

    final private int code;
    final private String desc;

    CompleteStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
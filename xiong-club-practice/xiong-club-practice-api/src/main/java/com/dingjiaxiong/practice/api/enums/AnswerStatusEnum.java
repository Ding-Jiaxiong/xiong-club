package com.dingjiaxiong.practice.api.enums;

public enum AnswerStatusEnum {

    /**
     * 错误
     */
    ERROR(0, "错误"),

    /**
     * 正确
     */
    CORRECT(1, "正确");

    final private int code;
    final private String desc;

    AnswerStatusEnum(int code, String desc) {
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
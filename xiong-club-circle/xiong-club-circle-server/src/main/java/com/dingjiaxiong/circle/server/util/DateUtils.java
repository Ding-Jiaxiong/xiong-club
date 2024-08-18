package com.dingjiaxiong.circle.server.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtils {

    /**
     * 字符串转时间
     */
    public static Date parseStrToDate(String timestamp) {
        try {
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sm.parse(timestamp);
        } catch (Exception e) {
            log.error("parseDate异常{}", timestamp, e.getMessage(), e);
            return null;
        }
    }

    /**
     * 日期格式化
     */
    public static String format(Date date, String format) {
        try {
            if (date == null) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            log.error("日期格式化失败{}", e.getMessage(), e);
        }
        return null;
    }

}
package com.dingjiaxiong.circle.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author Ding Jiaxiong
 * @since 2024/05/18
 */
@Getter
@Setter
public class ShareMessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 消息内容
     */
    private Map<String, Object> content;

    /**
     * 创建时间
     */
    private Date createdTime;

}

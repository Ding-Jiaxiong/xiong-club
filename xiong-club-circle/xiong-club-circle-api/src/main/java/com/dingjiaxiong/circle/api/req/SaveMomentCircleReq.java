package com.dingjiaxiong.circle.api.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 动态内容信息
 * </p>
 *
 * @author ChickenWing
 * @since 2024/05/16
 */
@Getter
@Setter
public class SaveMomentCircleReq implements Serializable {

    /**
     * 圈子ID
     */
    private Long circleId;

    /**
     * 动态内容
     */
    private String content;

    /**
     * 动态图片内容
     */
    private List<String> picUrlList;

}

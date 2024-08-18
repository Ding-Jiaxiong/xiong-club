package com.dingjiaxiong.circle.api.common;

import lombok.Getter;

import java.util.List;
import java.util.Objects;


public abstract class TreeNode {

    /**
     * 当前节点id
     */
    public abstract Long getNodeId();

    /**
     * 父级节点id
     */
    public abstract Long getNodePId();

    /**
     * 是否根节点
     */
    @Getter
    private Boolean rootNode;

    /**
     * 是否叶子节点
     **/
    @Getter
    private Boolean leafNode;

    /**
     * 子节点数据
     **/
    @Getter
    private List<TreeNode> children;

    /**
     * 设置子节点数据，设置为protected禁止外部调用
     **/
    public void setChildren(List<TreeNode> children) {
        this.children = children;
        this.rootNode = Objects.equals(getNodePId(), -1L);
        this.leafNode = children == null || children.isEmpty();
    }

}

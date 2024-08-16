package com.dingjiaxiong.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

@Data
public class EsIndexInfo implements Serializable {

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 索引名称
     */
    private String indexName;

}

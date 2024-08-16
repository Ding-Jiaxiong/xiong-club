package com.dingjiaxiong.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class EsSourceData implements Serializable {

    private String docId;

    private Map<String, Object> data;

}

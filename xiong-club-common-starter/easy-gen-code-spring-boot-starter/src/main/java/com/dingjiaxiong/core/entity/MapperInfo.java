package com.dingjiaxiong.core.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.velocity.VelocityContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 映射关系包裹对象
 *
 * @author loser
 * @date 2023/9/4
 */
@Data
public class MapperInfo {

    /**
     * 文件id用于自定义忘 context 中存入自己特有的信息
     */
    private String fileId;

    /**
     * 模板路径
     */
    private String templatePath;

    /**
     * 生成文件路径
     */
    private String outPutPath;

    /**
     * 每个文件自个持有的上下文  包含全局的上下文数据
     */
    private VelocityContext context;

    @Override
    public String toString() {
        Map<String, Object> res = new HashMap<>();
        res.put("fileId", fileId);
        res.put("templatePath", templatePath);
        res.put("outPutPath", outPutPath);
        return JSONObject.toJSONString(res);
    }
}

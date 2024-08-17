package com.dingjiaxiong.core.utils;

import com.dingjiaxiong.core.core.CodeGenerationCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * yml 转对象工具类
 *
 * @author loser
 * @date 2023/9/4
 */
public class YamlUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    public static <T> T loadYaml(String filePath, Class<T> valueType) {
        try {
            ClassLoader classLoader = CodeGenerationCode.class.getClassLoader();
            URL resource = classLoader.getResource(filePath);
            InputStream inputStream = resource.openStream();
            return objectMapper.readValue(inputStream, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

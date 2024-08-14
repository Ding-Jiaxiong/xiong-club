package com.dingjiaxiong.oss.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dingjiaxiong.oss.adapter.AliStorageAdapter;
import com.dingjiaxiong.oss.adapter.MinioStorageAdapter;
import com.dingjiaxiong.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件存储config
 *
 * @author: ChickenWing
 * @date: 2023/10/14
 */
@Configuration
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}

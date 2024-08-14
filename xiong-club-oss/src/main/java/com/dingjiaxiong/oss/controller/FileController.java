package com.dingjiaxiong.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dingjiaxiong.oss.service.FileService;
import com.dingjiaxiong.oss.util.MinioUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件操作controller
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/14
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    @NacosValue(value = "${storage.service.type}", autoRefreshed = true)
    private String storagetttype;

    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return allBucket.get(0);
    }

    @RequestMapping("/testNacos")
    public String testNacos() throws Exception {

        return storagetttype;
    }

}

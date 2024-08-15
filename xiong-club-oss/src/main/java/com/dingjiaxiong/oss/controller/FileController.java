package com.dingjiaxiong.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dingjiaxiong.oss.entity.Result;
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

    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucket, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }
}

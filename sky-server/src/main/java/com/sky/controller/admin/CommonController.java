package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AwsS3Util;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * common interface
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "General interface")
@Slf4j
public class CommonController {
    @Autowired
    private AwsS3Util awsS3Util;
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        log.info("Data uploading: {}", file);
        try {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = UUID.randomUUID().toString() + extension;
            String filePath = awsS3Util.upload(file.getBytes(),objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("Error while uploading file", e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}

package com.sky.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Data
@AllArgsConstructor
@Slf4j
public class AwsS3Util {

    private static String region;
    private static String accessKeyId;
    private static String secretAccessKey;
    private static String bucketName;

    public AwsS3Util(String region, String accessKeyId, String secretAccessKey, String bucketName) {
        this.region = region;
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.bucketName = bucketName;
    }
    /**
     * 上传文件到 S3
     * @param bytes 文件内容
     * @param objectName 上传后的对象名（路径+文件名）
     * @return 公网访问地址
     */
    public static String upload(byte[] bytes, String objectName) {
        // 构建 S3 客户端
        S3Client s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();

        try {
            // 构建上传请求
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectName)
                    .build();

            // 执行上传
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytes));
        } catch (Exception e) {
            log.error("S3 上传失败: {}", e.getMessage(), e);
            return null;
        } finally {
            s3Client.close();
        }

        // 拼接访问链接（需要 S3 设置为公网可访问）
        String fileUrl = String.format("https://%s.s3.%s.amazonaws.com/%s",
                bucketName,
                region,
                URLEncoder.encode(objectName, StandardCharsets.UTF_8)
        );

        log.info("文件上传到: {}", fileUrl);
        return fileUrl;
    }
}


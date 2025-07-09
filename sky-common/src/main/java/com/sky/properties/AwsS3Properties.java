package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sky.awss3")
public class AwsS3Properties {
    private String region;
    private String accessKeyId;
    private String secretAccessKey;
    private String bucketName;
}


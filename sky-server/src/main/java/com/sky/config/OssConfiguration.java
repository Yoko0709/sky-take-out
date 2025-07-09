package com.sky.config;

import com.sky.properties.AwsS3Properties;
import com.sky.utils.AwsS3Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.AllArgsConstructor;
/**
 * Configuration class
 */
@Configuration
@Slf4j
@AllArgsConstructor
public class OssConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public AwsS3Util awsS3Util(AwsS3Properties awsS3Properties){
        log.info("AwsS3Util init: {}", awsS3Properties);
        return new AwsS3Util(awsS3Properties.getRegion(),
                awsS3Properties.getAccessKeyId(),
                awsS3Properties.getSecretAccessKey(),
                awsS3Properties.getBucketName());
    }
}

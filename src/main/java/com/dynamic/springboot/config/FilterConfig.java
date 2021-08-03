package com.dynamic.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyichun
 * @since 2021/8/3 14:51
 */
@Configuration
@ServletComponentScan
@EnableConfigurationProperties(DynamicHeaderProperties.class)
public class FilterConfig {
}

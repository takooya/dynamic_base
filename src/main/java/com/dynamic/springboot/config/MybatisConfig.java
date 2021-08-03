package com.dynamic.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyichun
 * @since 2021/8/3 11:03
 */
@Configuration
@MapperScan(basePackages = {"com.dynamic.springboot.mapper"})
public class MybatisConfig {
}

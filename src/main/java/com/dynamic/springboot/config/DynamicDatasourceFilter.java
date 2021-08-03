package com.dynamic.springboot.config;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.dynamic.springboot.constants.DataSourcePoolNameConstant.MASTER;
import static com.dynamic.springboot.constants.DataSourcePoolNameConstant.SLAVE_1;

@Slf4j
@Component
@WebFilter(filterName = "dsFilter", urlPatterns = {"/*"})
public class DynamicDatasourceFilter implements Filter {

    @Autowired
    private DynamicHeaderProperties dynamicHeaderProperties;

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("[-DynamicDatasourceFilter-].init:{}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        log.info("[-DynamicDatasourceFilter-].doFilter:uri={}", uri);
        String poolname = request.getHeader(dynamicHeaderProperties.getHeadername());
        String dsKey = MASTER;
        if (CharSequenceUtil.isNotBlank(poolname)) {
            if (MASTER.equals(poolname)) {
                dsKey = MASTER;
            } else if (SLAVE_1.equals(poolname)) {
                dsKey = SLAVE_1;
            } else {
                throw new RuntimeException("无此数据源，请求头参数错误！");
            }
        }
        //执行
        try {
            DynamicDataSourceContextHolder.push(dsKey);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }

    @Override
    public void destroy() {

    }
}
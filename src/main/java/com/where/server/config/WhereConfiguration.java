package com.where.server.config;


import org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.filter.OrderedHttpPutFormContentFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WhereConfiguration {

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilterRegistration(OrderedHiddenHttpMethodFilter filter) {
        FilterRegistrationBean filterBean = new FilterRegistrationBean(filter);
        filterBean.setEnabled(false);

        return filterBean;
    }

    @Bean
    public FilterRegistrationBean httpPutFormContentFilterRegistration(OrderedHttpPutFormContentFilter filter) {
        FilterRegistrationBean filterBean = new FilterRegistrationBean(filter);
        filterBean.setEnabled(false);

        return filterBean;
    }
}

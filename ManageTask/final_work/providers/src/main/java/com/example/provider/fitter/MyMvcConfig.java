package com.example.provider.fitter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //ע���Լ���������,���������ص�����·��
        //addPathPatternsΪ���ش�����·��������
        //excludePathPatternsΪ�����ش�·��������

        registry.addInterceptor(loginInterceptor).addPathPatterns("/index").excludePathPatterns("/tologin");
    }

}

package com.online.demo.config;

import com.online.demo.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {


    // 生成一个bean 交给 spring管理， 否则  在 AuthIntercepter  中使用  @Reference 注入失败
    @Bean
    public AuthInterceptor getAuthIntercepter(){
        return new AuthInterceptor();
    }

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthIntercepter())
            .addPathPatterns("/**"); // 拦截的路径
    }

    // 跨域全局配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
            // 设置允许跨域请求的域名
            .allowedOrigins("*")
            // 是否允许证书
            .allowCredentials(true)
            // 设置允许的方法
            .allowedMethods("*")
            // 跨域允许时间
            .maxAge(3600);
    }
}

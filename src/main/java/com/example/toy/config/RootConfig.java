package com.example.toy.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.example.toy.api","com.example.toy.utils"})
public class RootConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry regi) {
        /*
        regi.addInterceptor()
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger/**")
                .excludePathPatterns("/v2/api-docs")
                .excludePathPatterns("swagger-resources/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/webjars/**");
        */
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry regi) {
        regi.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        regi.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry cors) {
        cors.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}

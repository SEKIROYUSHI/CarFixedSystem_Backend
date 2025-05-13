// 全局跨域配置类（路径：com.carSys.Config.CorsConfig）
package com.carSys.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // 匹配所有接口
                        .allowedOrigins("*")  // 允许所有前端域名（生产环境建议指定具体域名）
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                        .allowedHeaders("*");  // 允许的请求头
            }
        };
    }
}
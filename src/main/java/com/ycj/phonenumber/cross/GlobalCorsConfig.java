package com.ycj.phonenumber.cross;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/22
 * @time: 12:44
 * @fuction: about the role of class.
 */


//@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {


        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();

        //1) 允许的域,不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("http://localhost:8080/");

        config.addAllowedOrigin("http://localhost:8090/");


        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);

        //3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");

        config.addAllowedMethod("HEAD");

        config.addAllowedMethod("GET");

        config.addAllowedMethod("PUT");

        config.addAllowedMethod("POST");

        config.addAllowedMethod("DELETE");

        config.addAllowedMethod("PATCH");

        // 4）允许的头信息
        config.addAllowedHeader("*");


        // 5) 有效时长
        config.setMaxAge(3600L);


        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();

        configSource.registerCorsConfiguration("/**", config);


        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);

    }

}

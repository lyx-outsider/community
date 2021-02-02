package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration//普通的配置类直接用这个注解表示这是个配置类，而不用使用@SpringBootApplicatio
//这个注解，这个注解一般表示项目的入口
public class AlphaConfig {


    //总的表示下面那个方法的返回的对象将被装配到容器里
    @Bean//表示定义第三方的Bean,装配一个Bean,//实例化一次，装配到bean中可以反复用
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}

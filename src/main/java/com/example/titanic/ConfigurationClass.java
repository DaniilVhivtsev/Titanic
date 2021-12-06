package com.example.titanic;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example.titanic")
public class ConfigurationClass {
}

//@Configuration
//public class ConfigurationClass implements WebMvcConfigurer {
//
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("authorization/login_page");
//    }
//}
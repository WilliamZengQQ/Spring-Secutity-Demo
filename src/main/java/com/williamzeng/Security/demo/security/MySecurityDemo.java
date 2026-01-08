package com.williamzeng.Security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableSpringDataWebSupport //InMemory固定使用的annotation
public class MySecurityDemo {
    
    /*
    *以下寫法為InMemory固定寫法，為了進行(寫死)測試使用
    */
    @Bean 
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userTest1 = User
                                .withUsername("test1")
                                .password("{noop}111") //{noop}為前綴用途為指定要哪一種加密技術
                                .roles("ADMIN","USER") //權限角色
                                .build();

        UserDetails userTest2 = User
                                .withUsername("test2")
                                .password("{noop}222")
                                .roles("USER")
                                .build();
        
        return new InMemoryUserDetailsManager(userTest1,userTest2);
    }
    
}

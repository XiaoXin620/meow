package com.mason.meow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                //使用内存中的InMemoryUserDetailsManager(内存用户管理器)
                        inMemoryAuthentication()
                //不使用passwordEncoder密码加密
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                //在内存中给配置user用户
                .withUser("admin").password("admin").roles("admin")
                .and()
                //在内存中配置admin用户
                .withUser("user").password("user").roles("user");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                //对所有请求进行权限认证
                        authorizeRequests()
                //自定义配置请求地址权限
                .mvcMatchers("/hello1").permitAll()

                .anyRequest().authenticated()       //所有请求都需要进行认证
                .and()
                .formLogin()
                //.loginPage("login")       自定义登陆页面
                .permitAll()        //所有用户都可以访问
                .and()
                .logout()
                //.logoutUrl("logout")      自定义配置退出登陆页面
                .permitAll();
    }
}

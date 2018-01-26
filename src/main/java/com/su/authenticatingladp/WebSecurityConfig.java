/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.authenticatingladp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author suxiongye
 * @Package com.su.authenticatingladp
 * @Description: TODO
 * @date 2018/1/26 10:29
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
            .url("ldap://localhost:8389/dc=springframework,dc=org").and().passwordCompare()
            .passwordEncoder(new LdapShaPasswordEncoder()).passwordAttribute("userPassword");
    }
}

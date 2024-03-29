package com.zeed.okta.oktaredirectserver;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/redirect/oauth2/code/okta").permitAll()
                .anyRequest().authenticated()
            .and()
                .oauth2ResourceServer().jwt(); //or .opaqueToken();

            // process CORS annotations
            http.cors();

            // force a non-empty response body for 401's to make the response more browser friendly
            Okta.configureResourceServer401ResponseBody(http);
        }
    }
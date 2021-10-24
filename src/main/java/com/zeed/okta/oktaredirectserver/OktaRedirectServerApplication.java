package com.zeed.okta.oktaredirectserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class OktaRedirectServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OktaRedirectServerApplication.class, args);
    }


    @GetMapping("/redirect/oauth2/code/okta")
    public String redirect(@RequestParam String code) {
        return "Hello";
    }

    @GetMapping("/test-resource")
    public String testResource(@AuthenticationPrincipal OidcUser oidcUser, Principal principal, @RequestParam String code) {
        return "Testing resource";
    }

}

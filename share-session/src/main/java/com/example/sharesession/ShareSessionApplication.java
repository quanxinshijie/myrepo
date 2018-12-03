package com.example.sharesession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableRedisHttpSession
public class ShareSessionApplication {

    @GetMapping("/user/info")
    public Authentication info(Authentication authentication){
        return authentication;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShareSessionApplication.class, args);
    }
}

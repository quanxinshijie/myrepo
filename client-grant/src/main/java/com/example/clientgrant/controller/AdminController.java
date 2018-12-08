package com.example.clientgrant.controller;

import com.example.clientgrant.bean.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
@Slf4j
public class AdminController {
    @RequestMapping("/users") 
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.ok(getUsers());
    } 
    
    private List<UserProfile> getUsers() { 
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile("adolfo", "adolfo@mailinator.com")); 
        users.add(new UserProfile("demigreite", "demigreite@mailinator.com")); 
        users.add(new UserProfile("jujuba", "jujuba@mailinator.com")); 
        return users; 
    }

    @RequestMapping("/profile")
    public ResponseEntity<Object> hello() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return ResponseEntity.ok(principal);
    }

    @RequestMapping("/info")
    public ResponseEntity<Authentication> getUserInfo(Authentication authentication) {
        log.info("用户信息为:{}",authentication);
        return ResponseEntity.ok(authentication);
    }

}
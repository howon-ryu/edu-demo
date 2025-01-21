package com.example.demo.controller;

import com.example.demo.dto.UserPurchaseResponse;
import com.example.demo.service.UserPurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserPurchaseController {

    private final UserPurchaseService userPurchaseService;

    public UserPurchaseController(UserPurchaseService userPurchaseService) {
        this.userPurchaseService = userPurchaseService;
    }

    @GetMapping("/{userNo}/purchases")
    public UserPurchaseResponse getUserPurchases(@PathVariable String userNo) {
        return userPurchaseService.getUserPurchases(userNo);
    }
}
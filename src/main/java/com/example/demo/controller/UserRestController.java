package com.example.demo.controller;

import com.example.demo.dto.UserInfoResponse;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.example.demo.controller
 * fileName       : UserRestController
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<UserInfoResponse> getUserByuserNo(@PathVariable String userNo) {
        UserInfoResponse userInfoResponse = userService.getUserByuserNo(userNo);
        return ResponseEntity.ok(userInfoResponse);
    }
}

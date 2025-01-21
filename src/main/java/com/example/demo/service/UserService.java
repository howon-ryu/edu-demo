package com.example.demo.service;

import com.example.demo.dto.UserInfoResponse;
import com.example.demo.dto.UserPurchaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * packageName    : com.example.demo.service
 * fileName       : UserService
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@Service
public class UserService {

    private final RestTemplate restTemplate;

    // edu-goods 서비스 베이스 URL k8s configMap 통해 주입받음
    @Value("${goods.service.url:http://edu-goods.211.253.25.128.sslip.io}")
    private String goodsServiceUrl;

    @Value("${app.run.type:local}")
    String appRunType;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public UserService(@Value("${app.run.type:local}") String appRunType) {
//        this.appRunType = appRunType;
//    }

    public UserInfoResponse getUserByuserNo(String userNo) {

        UserInfoResponse userInfoResponse = UserInfoResponse.builder()
                .userNo(userNo)
                .userName(appRunType + "-" + userNo)
                .build();

        // edu-goods 서비스 호출
        String url = goodsServiceUrl + "/api/v1/user/" + userNo + "/products";
        try {
            UserPurchaseResponse userPurchaseResponse = restTemplate.getForObject(url, UserPurchaseResponse.class);
            if (userPurchaseResponse != null) {
                userInfoResponse.setProducts(userPurchaseResponse.getProducts());
            } else {
                userInfoResponse.setProducts(Collections.emptyList());
            }
        } catch (Exception e) {
            // 예외 처리 - 상품 리스트를 빈 리스트로 설정
            userInfoResponse.setProducts(Collections.emptyList());
        }

        return userInfoResponse;
    }
}

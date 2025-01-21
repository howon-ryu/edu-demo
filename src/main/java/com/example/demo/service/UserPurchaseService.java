package com.example.demo.service;

import com.example.demo.dto.Product;
import com.example.demo.dto.UserPurchaseResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserPurchaseService {

    public UserPurchaseResponse getUserPurchases(String userNo) {
        // 예제 데이터 반환 (실제 데이터베이스 연동 필요)
        List<Product> products = Arrays.asList(
            Product.builder()
                .id(101L)
                .title("macBook14")
                .build()
        );
        return new UserPurchaseResponse(products);
    }
}
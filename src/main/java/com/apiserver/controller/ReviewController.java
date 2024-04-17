package com.apiserver.controller;

import com.apiserver.dto.ProductDTO;
import com.apiserver.mappers.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    final ReviewMapper reviewMapper;

    @GetMapping("/order_products")
    public List<ProductDTO> get_order_product(@RequestParam("userId") String userId) {
//        System.out.println(userId);
        return reviewMapper.get_order_product(userId);
    }
}

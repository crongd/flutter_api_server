package com.apiserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiServerApplicationTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    void contextLoads() {
        System.out.println(productMapper.select_product(1));
//        System.out.println(productMapper.select_product_list());
    }

}

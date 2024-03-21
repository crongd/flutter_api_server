package com.apiserver;

import com.apiserver.dto.ProductDTO;
import com.apiserver.mappers.CategoryMapper;
import com.apiserver.mappers.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiServerApplicationTests {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;


    @Test
    void contextLoads() {
//        System.out.println(productMapper.select_product(1));
//        System.out.println(productMapper.select_product_list(0));
//        System.out.println(productMapper.select_basket_product());
//        System.out.println(categoryMapper.select_parent_category());

//        System.out.println(categoryMapper.select_parent_category(0));
        System.out.println(productMapper.select_product(666));
    }

}

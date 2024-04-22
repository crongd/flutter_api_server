package com.apiserver;

import com.apiserver.dto.ProductDTO;
import com.apiserver.mappers.CategoryMapper;
import com.apiserver.mappers.OrderMapper;
import com.apiserver.mappers.ProductMapper;
import com.apiserver.mappers.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ApiServerApplicationTests {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ReviewMapper reviewMapper;

    @Test
    void contextLoads() {
//        System.out.println(productMapper.select_product(409));
//        System.out.println(productMapper.select_product_list(1));
//        System.out.println(productMapper.select_basket_product("test"));
//        System.out.println(categoryMapper.select_parent_category());

//        System.out.println(categoryMapper.select_parent_category(0));
//        System.out.println(productMapper.select_product(666));
//        System.out.println(productMapper.best_selling_products().size());
//        System.out.println(productMapper.recent_products());
//        System.out.println(categoryMapper.select_all_category().size());
//        System.out.println(categoryMapper.select_all_category().get(0).getCategorys().size());
//        System.out.println(orderMapper.order_of_product("jaeho9859").get(0));
//        System.out.println(productMapper.main_image());
//        System.out.println(reviewMapper.get_order_product("jaeho9859").get(0));
//        System.out.println(reviewMapper.get_written_review("jaeho9859").size());
        System.out.println(UUID.randomUUID());

//        System.out.println(System.currentTimeMillis());
    }

}

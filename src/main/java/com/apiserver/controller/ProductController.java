package com.apiserver.controller;

import com.apiserver.mappers.ProductMapper;
import com.apiserver.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("/product_list")
    public List<ProductDTO> select_list(@RequestParam("no") String no) {
        System.out.println(no);
        return productMapper.select_product_list(Integer.parseInt(no));
    }

    @GetMapping("/product")
    public ProductDTO select_product(@RequestParam("no") String no) {
        return productMapper.select_product(Integer.parseInt(no));
    }

    @GetMapping("/basket_product")
    public List<ProductDTO> select_basket() {
        return productMapper.select_basket_product();
    }


}

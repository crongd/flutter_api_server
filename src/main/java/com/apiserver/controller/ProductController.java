package com.apiserver.controller;

import com.apiserver.dto.ShoppingCartDTO;
import com.apiserver.dto.UserDTO;
import com.apiserver.mappers.ProductMapper;
import com.apiserver.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("/product_list")
    public List<ProductDTO> select_list(@RequestParam("no") String no) {
//        System.out.println(no);
        return productMapper.select_product_list(Integer.parseInt(no));
    }

    @GetMapping("/product_search_list")
    public List<ProductDTO> select_search_list(@RequestParam("no") String no, @RequestParam("search") String search) {
//        System.out.println("search로 들어옴");
        return productMapper.search_product_list(Integer.parseInt(no), search);
    }

    @GetMapping("/product")
    public ProductDTO select_product(@RequestParam("no") String no) {
        ProductDTO result = productMapper.select_product(Integer.parseInt(no));
        result.getReviews().forEach(review -> {
            review.setWriteDate(review.getWriteDate().split(" ")[0]);
        });
//        System.out.println(result);
        return result;
    }

    @GetMapping("/basket_product/{userId}")
    public List<ProductDTO> select_basket(@PathVariable("userId") String userId) {
//        System.out.println(userId);
        return productMapper.select_basket_product(userId);
    }

    @PostMapping("/shopCart_product")
    @Transactional
    public void cart_insert(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        productMapper.shopping_cart_insert(shoppingCartDTO);
        productMapper.shopping_cart_option_insert(shoppingCartDTO);
    }

    @PatchMapping("/shopCart_amount_update")
    public void cart_product_amount_update(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        System.out.println(shoppingCartDTO);
        productMapper.shopping_cart_amount_update(shoppingCartDTO);
    }

    @DeleteMapping("/shopCart_delete")
    public void cart_product_delete(@RequestBody ShoppingCartDTO shoppingCartDTO) {
//        System.out.println(shoppingCartDTO);
        productMapper.shopping_cart_delete(shoppingCartDTO);
        productMapper.shopping_cart_option_delete(shoppingCartDTO);
    }

    @GetMapping("/recent_products")
    public List<ProductDTO> recent_products() {
        return productMapper.recent_products();
    }

    @GetMapping("/best_selling_products")
    public List<ProductDTO> best_selling_products() {
        return productMapper.best_selling_products();
    }

    @GetMapping("/main_image")
    public List<String> main_image() {
        return productMapper.main_image();
    }
}

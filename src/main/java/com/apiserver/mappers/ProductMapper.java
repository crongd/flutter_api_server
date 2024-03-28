package com.apiserver.mappers;

import com.apiserver.dto.ProductDTO;
import com.apiserver.dto.ShoppingCartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> select_product_list(int no);

    ProductDTO select_product(int no);

    List<ProductDTO> select_basket_product(String userId);

    void shopping_cart_insert(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_option_insert(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_amount_update(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_delete(ShoppingCartDTO shoppingCartDTO);

}


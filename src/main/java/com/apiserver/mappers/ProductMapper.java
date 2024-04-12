package com.apiserver.mappers;

import com.apiserver.dto.ProductDTO;
import com.apiserver.dto.ShoppingCartDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> select_product_list(int no);

    List<ProductDTO> search_product_list(@Param("no") int no,@Param("search") String search);

    ProductDTO select_product(int no);

    List<ProductDTO> select_basket_product(String userId);

    void shopping_cart_insert(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_option_insert(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_amount_update(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_delete(ShoppingCartDTO shoppingCartDTO);

    void shopping_cart_option_delete(ShoppingCartDTO shoppingCartDTO);

    List<ProductDTO> best_selling_products();

    List<ProductDTO> recent_products();

}


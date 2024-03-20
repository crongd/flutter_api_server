package com.apiserver.mappers;

import com.apiserver.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> select_product_list(int no);

    ProductDTO select_product(int no);

    List<ProductDTO> select_basket_product();
}


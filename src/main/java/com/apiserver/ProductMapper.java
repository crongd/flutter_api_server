package com.apiserver;

import com.apiserver.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> select_product_list();

    ProductDTO select_product(int no);
}


package com.apiserver.mappers;

import com.apiserver.dto.ProductDTO;
import com.apiserver.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

//    List<ReviewDTO> get
    List<ProductDTO> get_order_product(String userId);
}

package com.apiserver.mappers;

import com.apiserver.dto.ProductDTO;
import com.apiserver.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

//    List<ReviewDTO> get
    List<ProductDTO> get_order_product(String userId);

    List<ReviewDTO> get_written_review(String userId);

    void add_review(ReviewDTO reviewDTO);

    void review_like_add(@Param("no") int no, @Param("userId") String userId);

    void review_like_delete(@Param("no") int no, @Param("userId") String userId);

}

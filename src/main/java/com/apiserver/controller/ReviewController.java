package com.apiserver.controller;

import com.apiserver.dto.ProductDTO;
import com.apiserver.dto.ReviewDTO;
import com.apiserver.mappers.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    final ReviewMapper reviewMapper;

    @GetMapping("/order_products")
    public List<ProductDTO> get_order_product(@RequestParam("userId") String userId) {
//        System.out.println(userId);
        return reviewMapper.get_order_product(userId);
    }

    @PostMapping("/review_write")
    public void review_write(@RequestBody ReviewDTO reviewDTO) {
//        System.out.println(reviewDTO);
        reviewMapper.add_review(reviewDTO);
    }

    @GetMapping("/written_reviews")
    public List<ReviewDTO> get_written_review(@RequestParam("userId") String userId) {
//        System.out.println(userId);
        List<ReviewDTO> reviews = reviewMapper.get_written_review(userId);
        reviews.forEach((review -> {
            review.setWriteDate(review.getWriteDate().split(" ")[0]);
        }));
        return reviews;
    }

    @PostMapping("/review_like")
    public void review_like(
            @RequestParam("reviewNo") String reviewNo,
            @RequestParam("userId") String userId
    ) {

    }
}

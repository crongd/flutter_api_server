package com.apiserver.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int no;
    private String title;
    private String mainImg;
    private List<String> images;
    private List<OptionDTO> options;
    private List<ReviewDTO> reviews;
    private int price;
    private int amount;
    private int orderProductNo;
}

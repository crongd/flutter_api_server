package com.apiserver.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private int no;
    private String userId;
    private int orderProductNo;
    private int productNo;
    private String content;
    private int rate;
    private ProductDTO product;
    private String writeDate;
    private double averageRate;
    private List<String> users;
}

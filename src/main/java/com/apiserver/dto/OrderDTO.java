package com.apiserver.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String impUid; // 결제건의 가맹점 주문번호
    private UserDTO user; // 유저
    private List<ProductDTO> products; // 상품들
    private String name;
    private String buyerAddr; // 주문자 주소
    private String buyerPostcode; // 주문자 우편번호
    private String createdAt;
    private int paidAt;
    private int amount; // 주문건의 총 가격
    private String payMethod;
    private String pgId;
}

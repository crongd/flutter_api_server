package com.apiserver.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    private int no;
    private String userId;
    private int productNo;
    private int amount;
    private int optionNo;
}

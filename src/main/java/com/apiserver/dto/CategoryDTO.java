package com.apiserver.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int no;
    private String name;
    private int parent_no;
    private int level;
}

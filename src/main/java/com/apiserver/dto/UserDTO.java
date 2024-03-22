package com.apiserver.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int no;
    private String id;
    private String pw;
    private String name;
}

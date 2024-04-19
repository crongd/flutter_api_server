package com.apiserver.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String ci;
    private String password;
    private String email;
    private String tel;
    private String joinDate;
    private String pwReToken;
    private LocalDateTime pwReTokenExpire;
}

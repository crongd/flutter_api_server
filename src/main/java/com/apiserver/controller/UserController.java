package com.apiserver.controller;

import com.apiserver.dto.UserDTO;
import com.apiserver.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @PostMapping("/user_join")
    public String user_join(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userMapper.user_join(userDTO);
        return "가입 성공";
    }

    @PostMapping("/user_login")
    public boolean user_login(@RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.user_login(userDTO);
        return !Objects.isNull(user) && Objects.equals(user.getPw(), userDTO.getPw());
    }
}

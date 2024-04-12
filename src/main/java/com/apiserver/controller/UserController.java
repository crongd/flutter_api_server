package com.apiserver.controller;

import com.apiserver.dto.UserDTO;
import com.apiserver.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user_join")
    public String user_join(@RequestBody UserDTO userDTO) {
//        userMapper.user_join(userDTO);
        String tel = "";
        tel += userDTO.getTel().substring(0, 3);
        tel += "-";
        tel += userDTO.getTel().substring(3, 7);
        tel += "-";
        tel += userDTO.getTel().substring(7, 11);
        userDTO.setTel(tel);
        System.out.println(userDTO);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userMapper.user_join(userDTO);
        return "가입 성공";
    }

    @PostMapping("/user_login")
    public boolean user_login(@RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.user_login(userDTO);
        return passwordEncoder.matches(userDTO.getPassword(), user.getPassword());
    }
}

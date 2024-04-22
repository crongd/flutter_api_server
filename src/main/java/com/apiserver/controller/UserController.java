package com.apiserver.controller;

import com.apiserver.PortOneService;
import com.apiserver.dto.UserDTO;
import com.apiserver.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;


@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final PortOneService portOneService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user_join/{imp_uid}")
    public Boolean user_join(
            @RequestBody UserDTO userDTO,
            @PathVariable("imp_uid") String impUID
    ) {
//        userMapper.user_join(userDTO);
        // 실제 인증한 전화번호
        System.out.println("join 들어옴");
        String resultPhone = portOneService.get_user_certification_phone(impUID, portOneService.get_access_token());
        if (Objects.equals(userDTO.getTel(), resultPhone)) {
            String tel = "";
            tel += userDTO.getTel().substring(0, 3);
            tel += "-";
            tel += userDTO.getTel().substring(3, 7);
            tel += "-";
            tel += userDTO.getTel().substring(7, 11);
            userDTO.setTel(tel);
            userDTO.setCi(UUID.randomUUID().toString());
            System.out.println(userDTO);
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userMapper.user_join(userDTO);
            return true;
        }

        return false;
    }

    @PostMapping("/user_login")
    public boolean user_login(@RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.user_login(userDTO);
        if (Objects.isNull(user)) {
            return false;
        }
        return passwordEncoder.matches(userDTO.getPassword(), user.getPassword());
    }

    @GetMapping("/user_info")
    public UserDTO user_info(@RequestParam("userId") String userId) {
        System.out.println(userId);
        UserDTO result = userMapper.user_login(UserDTO.builder().id(userId).build());
        result.setJoinDate(result.getJoinDate().split(" ")[0]);
        return result;
    }

    @PatchMapping("/user_password")
    public void user_re_password(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userMapper.user_re_password(userDTO);
    }
}

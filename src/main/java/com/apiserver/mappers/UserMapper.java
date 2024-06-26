package com.apiserver.mappers;

import com.apiserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void user_join(UserDTO userDTO);

    UserDTO user_login(UserDTO userDTO);

    void user_re_password(UserDTO userDTO);

    UserDTO user_id_check(String id);
}

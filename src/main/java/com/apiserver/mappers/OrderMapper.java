package com.apiserver.mappers;

import com.apiserver.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDTO> order_of_product(String id);
}

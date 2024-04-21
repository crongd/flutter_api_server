package com.apiserver.controller;

import com.apiserver.dto.OrderDTO;
import com.apiserver.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Log4j2
@RequiredArgsConstructor
public class OrderController {

    final OrderMapper orderMapper;

    @GetMapping("/get_orders")
    public List<OrderDTO> get_orders(@RequestParam("userId") String userId) {
//        System.out.println(userId);
        List<OrderDTO> result = orderMapper.order_of_product(userId);
        result.forEach(orderDTO -> {
            orderDTO.setCreatedAt(orderDTO.getCreatedAt().split(" ")[0]);
        });

        return result;
    }


}

package com.apiserver.controller;

import com.apiserver.dto.OrderDTO;
import com.apiserver.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/add_order")
    @Transactional
    public void add_order(@RequestBody OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());
        orderDTO.setPaidAt((int) System.currentTimeMillis());
        System.out.println(orderDTO);
        orderMapper.order_add(orderDTO);
        orderMapper.order_product_add(orderDTO);
        orderMapper.shopping_cart_delete(orderDTO);

    }


}

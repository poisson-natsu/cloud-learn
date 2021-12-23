package com.ouest.order.service;

import com.ouest.order.mapper.OrderMapper;
import com.ouest.order.pojo.Order;
import com.ouest.order.pojo.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderByOrderId(Long id) {
        Order order = orderMapper.selectById(id);
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}

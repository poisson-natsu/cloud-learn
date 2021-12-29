package com.ouest.order.service;

import com.ouest.feign.clients.UserClient;
import com.ouest.feign.pojo.User;
import com.ouest.order.mapper.OrderMapper;
import com.ouest.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderByOrderId(Long id) {
        Order order = orderMapper.selectById(id);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderByOrderId(Long id) {
//        Order order = orderMapper.selectById(id);
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//        return order;
//    }
}

package com.project.shopapp.services.interfaces;

import com.project.shopapp.dto.OrderDTO;

import com.project.shopapp.model.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(OrderDTO orderDTO) throws Exception;
    Order getOrder(Long id);
    Order updateOrder(Long id, OrderDTO orderDTO) throws Exception;
    void deleteOrder(Long id);
    List<Order> findByUserId(Long userId);
}

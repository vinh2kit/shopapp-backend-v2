package com.project.shopapp.services.interfaces;

import com.project.shopapp.dto.OrderDetailDTO;
import com.project.shopapp.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO newOrderDetail) throws Exception;
    OrderDetail getOrderDetail(Long id) throws Exception;
    OrderDetail updateOrderDetail(Long id, OrderDetailDTO newOrderDetailData)
            throws Exception;
    void deleteById(Long id);
    List<OrderDetail> findByOrderId(Long orderId);


}

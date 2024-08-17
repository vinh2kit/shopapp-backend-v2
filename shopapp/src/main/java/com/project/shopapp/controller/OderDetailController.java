package com.project.shopapp.controller;

import com.project.shopapp.dto.OrderDTO;
import com.project.shopapp.dto.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/orderDetail")
public class OderDetailController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(
        @PathVariable("id") Long id
    ){
        try {
            return ResponseEntity.ok("ok" + id);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResponseEntity.badRequest().body("cant");
        }
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrdersDetail(
            @PathVariable("orderId") Long orderId
    ){
        try {
            return ResponseEntity.ok("ok" +orderId);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResponseEntity.badRequest().body("cant");
        }
    }
    @PostMapping
    public ResponseEntity<?> createdOrderDetail(
            @Valid @RequestBody OrderDTO orderDTO
            ){
        return ResponseEntity.ok("created " + orderDTO.getUserId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @PathVariable Long id,
            @Valid @RequestBody OrderDetailDTO newOrderDetailDTO
    ){
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(
            @PathVariable Long id
    ){
        return ResponseEntity.ok("delete ok");
    }
}

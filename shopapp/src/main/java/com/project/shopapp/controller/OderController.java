package com.project.shopapp.controller;

import com.project.shopapp.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OderController {

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(
        @PathVariable("user_id") Long userId
    ){
        try {
            return ResponseEntity.ok("ok" +userId);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResponseEntity.badRequest().body("cant");
        }
    }

    @PostMapping()
    public ResponseEntity<?> createdOrder(
            @Valid @RequestBody OrderDTO orderDTO
            ){
        return ResponseEntity.ok("created " + orderDTO.getUserId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody OrderDTO orderDTO
    ){
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(
            @PathVariable Long id
    ){
        return ResponseEntity.ok("delete ok");
    }
}

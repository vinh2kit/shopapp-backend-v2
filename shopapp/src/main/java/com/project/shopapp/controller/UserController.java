package com.project.shopapp.controller;

import com.project.shopapp.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody UserDTO userDTO) {
        try {
            if(!userDTO.getPassword().equals(userDTO.getRepeatPassword()))
                return ResponseEntity.badRequest().body("repeat password wrong");
            return ResponseEntity.ok("register ok");
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResponseEntity.badRequest().body("cant");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody UserDTO userDTO) {
        try {
//          kiểm tra login, create token
            return ResponseEntity.ok("login ok, token");
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResponseEntity.badRequest().body("cant");
        }
    }
}

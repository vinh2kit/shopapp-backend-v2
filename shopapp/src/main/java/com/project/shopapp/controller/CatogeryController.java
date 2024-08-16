package com.project.shopapp.controller;

import com.project.shopapp.dto.CatogeryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

//@Validated    cái này sẽ xét valid trước khi vào method nên sẽ k hiện mess lỗi
@RestController
@RequestMapping("api/v1/catogeries")
public class CatogeryController {
//    http://localhost:8088/api/v1/catogeries
    @GetMapping()
    public ResponseEntity<String> getAllCatogeries(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("show all ok");
    }
    @PostMapping()
    public ResponseEntity<String> insertCatogeries(
           @Valid @RequestBody CatogeryDTO catogeryDTO,
           BindingResult result
    ){
        return ResponseEntity.ok("insert ok");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCatogeries(@PathVariable long id){
        return ResponseEntity.ok("updated " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCatogeries(@PathVariable long id){
        return ResponseEntity.ok("deleted " + id);
    }
}

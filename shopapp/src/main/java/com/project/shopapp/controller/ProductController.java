package com.project.shopapp.controller;

import com.project.shopapp.dto.CategoryDTO;
import com.project.shopapp.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    //    http://localhost:8088/api/v1/products
    @GetMapping("")
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("show all ok");
    }
    @PostMapping("")
    public ResponseEntity<String> insertProduct(
            @Valid @RequestBody ProductDTO productDTO,
            BindingResult result
    ){
        return ResponseEntity.ok("insert ok");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id){
        return ResponseEntity.ok("updated " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id){
        return ResponseEntity.ok("deleted " + id);
    }
}

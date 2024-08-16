package com.project.shopapp.controller;

import com.project.shopapp.dto.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//@Validated    cái này sẽ xét valid trước khi vào method nên sẽ k hiện mess lỗi
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
//    http://localhost:8088/api/v1/categories
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("show all ok");
    }
    @PostMapping("")
    public ResponseEntity<String> insertCategory(
           @Valid @RequestBody CategoryDTO categoryDTO,
           BindingResult result
    ){
        return ResponseEntity.ok("insert ok");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.ok("updated " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return ResponseEntity.ok("deleted " + id);
    }
}

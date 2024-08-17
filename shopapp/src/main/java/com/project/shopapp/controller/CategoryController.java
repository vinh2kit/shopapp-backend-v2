package com.project.shopapp.controller;

import com.project.shopapp.dto.CategoryDTO;
import com.project.shopapp.model.Category;
import com.project.shopapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Validated    cái này sẽ xét valid trước khi vào method nên sẽ k hiện mess lỗi
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //    http://localhost:8088/api/v1/categories
    @GetMapping("")
    public ResponseEntity<?> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        List<Category> categories =  categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @PostMapping("")
    public ResponseEntity<?> insertCategory(
           @Valid @RequestBody CategoryDTO categoryDTO
    ){
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("insert ok");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok("updated ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long id,
            CategoryDTO categoryDTO){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("deleted ok");
    }
}

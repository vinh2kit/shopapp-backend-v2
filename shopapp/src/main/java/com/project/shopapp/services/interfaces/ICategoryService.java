package com.project.shopapp.services.interfaces;

import com.project.shopapp.dto.CategoryDTO;
import com.project.shopapp.model.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    Category updateCategory(long categoryId, CategoryDTO category);
    void deleteCategory(long id);
}

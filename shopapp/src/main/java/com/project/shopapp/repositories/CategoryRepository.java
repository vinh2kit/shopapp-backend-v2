package com.project.shopapp.repositories;

import com.project.shopapp.model.Category;
import com.project.shopapp.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

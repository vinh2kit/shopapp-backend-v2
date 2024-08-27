package com.project.shopapp.repositories;

import com.project.shopapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    Page<Product> findAll(Pageable pageable);//phân trang

    @Query(value = "SELECT * FROM products WHERE enabled = true AND "
            + "MATCH(name, description) AGAINST (:keyword) "
            + "AND category_id = :categoryId",
            nativeQuery = true)
    Page<Product> searchProducts(
            @Param("categoryId") Long categoryId,
            @Param("keyword") String keyword, Pageable pageable);
}

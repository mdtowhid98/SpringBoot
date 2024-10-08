package com.towhid.practicepharmacy.repository;

import com.towhid.practicepharmacy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.category.categoryname=:categoryName ")
    List<Product> finndProductByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p WHERE p.name=:productName ")
    List<Product> findProductByName(@Param("productName") String productName);

}

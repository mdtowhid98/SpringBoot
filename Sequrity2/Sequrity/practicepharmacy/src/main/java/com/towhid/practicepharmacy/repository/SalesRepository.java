package com.towhid.practicepharmacy.repository;

import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {

//    @Query("SELECT s FROM Sales s WHERE s.product.category.categoryname=:categoryName ")
//    List<Sales> finndSalesByCategoryName(@Param("categoryName") String categoryName);
//
//    @Query("SELECT s FROM Sales s WHERE s.product.name=:productName ")
//    List<Sales> finndSalesByProductName(@Param("productName") String productName);
//int countByProductId(int productId);

}

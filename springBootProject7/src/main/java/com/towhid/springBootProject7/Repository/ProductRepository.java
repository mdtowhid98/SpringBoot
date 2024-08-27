package com.towhid.springBootProject7.Repository;

import com.towhid.springBootProject7.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
}

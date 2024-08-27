package com.towhid.springBootProject7.Repository;

import com.towhid.springBootProject7.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {
}

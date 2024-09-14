package com.towhid.practicePharmacy2.repository;


import com.towhid.practicePharmacy2.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder,Long> {

}

package com.towhid.practicePharmacy2.repository;

import com.towhid.practicePharmacy2.entity.SalesMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesMedicineRepository extends JpaRepository<SalesMedicine,Long> {

}

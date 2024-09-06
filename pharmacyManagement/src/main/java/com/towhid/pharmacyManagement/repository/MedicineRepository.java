package com.towhid.pharmacyManagement.repository;

import com.towhid.pharmacyManagement.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MedicineRepository extends JpaRepository<Medicine,Long> {



}

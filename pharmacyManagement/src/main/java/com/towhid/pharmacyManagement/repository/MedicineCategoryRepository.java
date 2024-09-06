package com.towhid.pharmacyManagement.repository;

import com.towhid.pharmacyManagement.entity.MedicineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineCategoryRepository extends JpaRepository<MedicineCategory,Long> {

}

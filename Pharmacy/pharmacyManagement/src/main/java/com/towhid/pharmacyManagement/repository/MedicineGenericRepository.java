package com.towhid.pharmacyManagement.repository;

import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineGenericRepository extends JpaRepository<MedicineGeneric,Long> {

}

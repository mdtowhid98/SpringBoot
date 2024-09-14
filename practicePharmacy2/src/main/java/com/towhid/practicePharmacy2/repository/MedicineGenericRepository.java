package com.towhid.practicePharmacy2.repository;

import com.towhid.practicePharmacy2.entity.MedicineGeneric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineGenericRepository extends JpaRepository<MedicineGeneric,Long> {

}

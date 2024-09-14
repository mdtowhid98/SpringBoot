package com.towhid.pharmacyManagement.repository;

import com.towhid.pharmacyManagement.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    @Query("SELECT m FROM Medicine m WHERE m.generic.name=:genericName ")
    List<Medicine> finndMedicineByGenericName(@Param("genericName") String genericName);


}

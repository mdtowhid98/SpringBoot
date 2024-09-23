package com.towhid.pharmacyManagement.repository;

import com.towhid.pharmacyManagement.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist,Long> {

}

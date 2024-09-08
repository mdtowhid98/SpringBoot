package com.aminul.propertyapplication.repository;

import com.aminul.propertyapplication.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence,Integer> {
}

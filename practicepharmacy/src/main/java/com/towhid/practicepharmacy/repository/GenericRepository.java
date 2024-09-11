package com.towhid.practicepharmacy.repository;

import com.towhid.practicepharmacy.entity.Generic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<Generic,Integer> {
    
}

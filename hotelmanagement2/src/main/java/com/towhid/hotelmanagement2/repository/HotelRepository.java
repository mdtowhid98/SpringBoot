package com.towhid.hotelmanagement2.repository;

import com.towhid.hotelmanagement2.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

@Query("SELECT h FROM Hotel h WHERE h.location.name=:locationName ")
    List<Hotel>finndHotelByLocationName(@Param("locationName")String locationName);


}

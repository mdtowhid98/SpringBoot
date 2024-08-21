package com.towhid.springBootProject5.repository;

import com.towhid.springBootProject5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {




}

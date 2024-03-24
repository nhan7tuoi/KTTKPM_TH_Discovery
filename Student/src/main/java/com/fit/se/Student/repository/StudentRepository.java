package com.fit.se.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.se.Student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

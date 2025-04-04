package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//this res is an interface between database and data access level
@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {
    List<Student> findByEmail(String email);
}

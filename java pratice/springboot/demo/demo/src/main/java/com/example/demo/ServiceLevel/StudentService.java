package com.example.demo.ServiceLevel;


import com.example.demo.DAO.Student;
import com.example.demo.forFrontEnd.StudentFFE;

//interface for Student
public interface StudentService {
    public StudentFFE getStudentById(long id);

    Long addNewStudent(StudentFFE studentFFE);

    void deleteStudentById(long id);

    StudentFFE updateStudentById(long id, String name, String email);
}

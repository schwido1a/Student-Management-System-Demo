package com.example.demo.converter;


import com.example.demo.DAO.Student;
import com.example.demo.forFrontEnd.StudentFFE;

//this file can convert student to studentFFE or vice versa :)
public class StudentConverter {

    public static StudentFFE convertStudent(Student student){
        StudentFFE studentFFE = new StudentFFE();
        studentFFE.setId(student.getId());
        studentFFE.setEmail(student.getEmail());
        studentFFE.setName(student.getName());
        return studentFFE;
    }

    public static Student convertStudentFFE(StudentFFE studentFFE){
        Student student = new Student();
        student.setEmail(studentFFE.getEmail());
        student.setName(studentFFE.getName());
        return student;
    }


}

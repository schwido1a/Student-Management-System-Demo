package com.example.demo.ServiceLevel;

import com.example.demo.DAO.Student;
import com.example.demo.DAO.StudentRespository;
import com.example.demo.converter.StudentConverter;
import com.example.demo.forFrontEnd.StudentFFE;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;


//this makes all methods in StudentService happen
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRespository studentRespository;


    //get a student by id
    @Override
    public StudentFFE getStudentById(long id) {
        //simply return if find by id or throw a random exception if not found
        Student student = studentRespository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    //add a new studnet
    @Override
    public Long addNewStudent(StudentFFE studentFFE) {
        List<Student> studentList = studentRespository.findByEmail(studentFFE.getEmail());
        if (!CollectionUtils.isEmpty(studentList)){ // if taken then throw error message
            throw new IllegalStateException("email:" + studentFFE.getEmail() + "has been registered");
        }
        Student student = studentRespository.save(StudentConverter.convertStudentFFE(studentFFE));
        return student.getId();
    }


    //delete a student by ID if exist or throw exception
    @Override
    public void deleteStudentById(long id) {
        studentRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID:" + id + "does not exist"));
        studentRespository.deleteById(id);
    }


    //update a student with given id about either name or email
    @Override
    @Transactional // if update fails then roll back, yeah!
    public StudentFFE updateStudentById(long id, String name, String email) {
        Student studentInDB = studentRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID:" + id + "does not exist"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){ // if name is not empty and name is diff from whats currently in db
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student = studentRespository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }
}

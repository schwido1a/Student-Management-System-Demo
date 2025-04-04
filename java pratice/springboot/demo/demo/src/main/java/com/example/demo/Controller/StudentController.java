package com.example.demo.Controller;


import com.example.demo.DAO.Student;
import com.example.demo.Response;
import com.example.demo.ServiceLevel.StudentService;
import com.example.demo.forFrontEnd.StudentFFE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentFFE> getStudentById(@PathVariable long id){
        return Response.newSuccess(studentService.getStudentById(id));
    }


    //when front end developer want to add a new student
    @PostMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentFFE studentFFE){
        return Response.newSuccess(studentService.addNewStudent(studentFFE));
    }

    @DeleteMapping("student/{id}")
    public void deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
    }


    //update a current student
    @PutMapping("student/{id}")
    public Response<StudentFFE> updateStudentById(@PathVariable long id, @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String email){
        return Response.newSuccess(studentService.updateStudentById(id, name, email));
    }

}

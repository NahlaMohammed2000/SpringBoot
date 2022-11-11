package com.student.ust.controller;

import com.student.ust.entity.Student;
import com.student.ust.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController

public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student/{id}")
    public ResponseEntity<Student>get(@PathVariable Integer id){
        log.debug("Passed in ID is >>>>"+id);
        try{
            Student student =studentService.getStudentsByID(id);
            return new ResponseEntity<Student>(student,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/student")
    public ResponseEntity<Student> getStudentByID(@RequestParam Integer id){
        log.debug("Passed in ID is >>>>"+id);
        try{
            Student student =studentService.getStudentsByID(id);
            return new ResponseEntity<Student>(student,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/student")
    public void add(@RequestBody Student student){
        log.debug("Details are:"+student.getName()+" "+student.getAge()+" "+student.getRollNo());
        studentService.saveStudent(student);
    }



    @GetMapping("/student")
    public ResponseEntity<List<Student>> get(){
        try{
            List<Student> studentList=studentService.getAllStudent();
            return  new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable Integer id){
       studentService.deleteId(id);
    }

    @PutMapping("/student")
    public ResponseEntity<Student>put(@RequestBody Student student){
        try{
            Student updatedStudent =studentService.updateStudent(student);
            return new ResponseEntity<Student>(student,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
}

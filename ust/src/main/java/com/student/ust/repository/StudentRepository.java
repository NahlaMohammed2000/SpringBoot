package com.student.ust.repository;

import com.student.ust.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    Student findByName(String name);

    Student findByAge(int i);

    Student findByNameStartingWith(String n);




    @Query("SELECT s FROM Student s WHERE s.age =?1")
    Student findStudentByStatus(int i);

}

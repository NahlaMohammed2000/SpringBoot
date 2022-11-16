package com.student.ust.repository;

import com.student.ust.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    /**
     * Find by name student.
     *
     * @param name the name
     * @return the student
     */
    Student findByName(String name);

    /**
     * Find by age student.
     *
     * @param i the
     * @return the student
     */
    Student findByAge(int i);

    /**
     * Find by name starting with student.
     *
     * @param n the n
     * @return the student
     */
    Student findByNameStartingWith(String n);


    /**
     * Find student by status student.
     *
     * @param i the
     * @return the student
     */
    @Query("SELECT s FROM Student s WHERE s.age =?1")
    Student findStudentByStatus(int i);

}

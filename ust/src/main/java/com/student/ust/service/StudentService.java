package com.student.ust.service;

import com.student.ust.DTO.StudentDTO;
import com.student.ust.entity.Student;
import com.student.ust.exception.InvalidEmailException;
import com.student.ust.exception.InvalidPasswordException;
import com.student.ust.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static com.student.ust.util.USTUtil.*;

/**
 * The type Student service.
 */
@Service
@Slf4j
public class StudentService {

    /**
     * The Student repository.
     */
    @Autowired

    StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Gets students by id.
     *
     * @param id the id
     * @return the students by id
     * @throws NoSuchElementException the no such element exception
     */
    public Student getStudentsByID(Integer id ) throws NoSuchElementException {

        return studentRepository.findById(id).orElseThrow(()->new NoSuchElementException());

    }


    /**
     * Save student.
     *
     * @param student the student
     */
    public void saveStudent(Student student){
        boolean validEmail=ValidEmail(student);
        boolean validPassword=validPassword(student);
        if(validEmail && validPassword){
            student.setDateBirth(LocalDateTime.now());
            student.setModifiedDate(student.getDateBirth());
            String password=student.getPassword();
            student.setPassword(hashPassword(password));
            studentRepository.save(student);
        } else if (!validEmail) {
                throw new InvalidEmailException();
        }
        else {
            throw new InvalidPasswordException();
        }

    }

    /**
     * Get all student list.
     *
     * @return the list
     */
    public List<Student> getAllStudent(){
        log.debug(studentRepository.findByAge(22).getName());
        return studentRepository.findAll();
    }

    /**
     * Delete id.
     *
     * @param id the id
     */
    public void deleteId(Integer id){
       studentRepository.deleteById(id);

    }

    /**
     * Update student student.
     *
     * @param student the student
     * @return the student
     */
    public Student updateStudent(Student student){
        Student updateStudent=studentRepository.findById(student.getStudId()).orElseThrow(()->new NoSuchElementException());
        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());
        updateStudent.setRollNo(student.getRollNo());
        updateStudent.setModifiedDate(LocalDateTime.now());
        studentRepository.save(updateStudent);
        return updateStudent;
    }

    public StudentDTO converttoDTO(Student student) {
        return modelMapper.map(student,StudentDTO.class);
    }


    public List<StudentDTO> converttoDTO2(List<Student> studentList) {
        List<StudentDTO> studentDTOList=modelMapper.map(studentList,new TypeToken<List<StudentDTO>>() {}.getType());
        return studentDTOList;
    }
}

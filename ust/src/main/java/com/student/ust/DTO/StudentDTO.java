package com.student.ust.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class StudentDTO {
    private int studId;
    private int rollNo;
    private String name;
    private int age;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;


}

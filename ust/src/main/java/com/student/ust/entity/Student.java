package com.student.ust.entity;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

/**
 * The type Student.
 */

@Entity
@Data
@Table(name="student_ustbatch_mappedBy")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studId;
    private int rollNo;
    private String name;
    private int age;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;
    @Column(name="email",unique = true,nullable = false)
    private String email;
    @Column(name="password",nullable = false)
    private String password;

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    private Set<Book> bookSet;
}


package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name="book_ust_details_mappedBy")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String authName;
    private String bookName;
    private long isbn;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name="student_id")
    Student student;
}

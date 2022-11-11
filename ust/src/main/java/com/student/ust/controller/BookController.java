package com.student.ust.controller;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id){
        try{
            Book book =bookService.getBooksByID(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/books")
    public void add(@RequestBody Book book){

        bookService.saveBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Integer id){
        bookService.deleteBookId(id);
    }

    @PutMapping("/books")
    public ResponseEntity<Book>put(@RequestBody Book book){
        try{
            Book updatedBook =bookService.updateBook(book);
            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
}

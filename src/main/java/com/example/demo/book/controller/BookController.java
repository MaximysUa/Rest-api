package com.example.demo.book.controller;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookServiceImpl;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }



    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllUsers() {
        List<BookEntity> books = this.bookService.getAll();
        if (books.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable("id") Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        BookEntity bookEntity = this.bookService.get(id);
        if (bookEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity bookEntity) {
        if (bookEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.bookService.save(bookEntity);
        return new ResponseEntity<>(bookEntity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bookEntity) {
        if (bookEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.bookService.save(bookEntity);

        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable("id") Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        BookEntity bookEntity = this.bookService.get(id);
        if (bookEntity == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        this.bookService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<BookEntity> deleteAllBooks() {
        this.bookService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<BookEntity>> saveAllUsers(@RequestBody List<BookEntity> list) {
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.bookService.saveAll(list);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<BookEntity>> findAllByUserEntity(@RequestBody UserEntity userEntity) {

        List<BookEntity> books = this.bookService.findAllByUserEntity(userEntity);

        if (books.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/take/{id}")
    public ResponseEntity<BookEntity> takeABook(@PathVariable Long id,@RequestBody UserEntity userEntity) {
        if (userEntity == null || id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        BookEntity bookEntityFromDB = this.bookService.get(id);
        bookEntityFromDB.setUserEntity(userEntity);
        this.bookService.save(bookEntityFromDB);
        return new ResponseEntity<>(bookEntityFromDB, HttpStatus.OK);
    }
    @PutMapping("/return/{id}")
    public ResponseEntity<BookEntity> returnABook(@PathVariable Long id){
        BookEntity bookEntity = this.bookService.get(id);
        bookEntity.setUserEntity(this.userService.get(1L));
        this.bookService.save(bookEntity);
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }
}

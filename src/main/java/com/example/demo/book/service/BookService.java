package com.example.demo.book.service;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.user.entity.UserEntity;

import java.util.List;


public interface BookService {
    void save (BookEntity bookEntity);

    void saveAll (List<BookEntity> entityList);


    BookEntity get (Long id);

    List<BookEntity> getAll ();

    void deleteAll ();

    void deleteById (Long id);

    List<BookEntity> findAllByUserEntity (UserEntity userEntity);
}

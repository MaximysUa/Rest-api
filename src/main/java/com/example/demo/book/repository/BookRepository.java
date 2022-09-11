package com.example.demo.book.repository;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAllByUserEntity (UserEntity userEntity);
}

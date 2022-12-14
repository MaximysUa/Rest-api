package com.example.demo.user.repository;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity getById (Long id);

    List<UserEntity> findAll ();




}

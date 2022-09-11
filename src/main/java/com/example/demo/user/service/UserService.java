package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;

import java.util.List;

public interface UserService {

    void save (UserEntity userEntity);

    void saveAll (List<UserEntity> entityList);

    UserEntity get (Long id);

    List<UserEntity> getAll ();

    void deleteAll ();

    void deleteById (Long id);
}

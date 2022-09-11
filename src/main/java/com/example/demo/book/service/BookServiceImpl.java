package com.example.demo.book.service;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void save(BookEntity bookEntity) {
        if (bookEntity.getUserEntity() == null) bookEntity.setUserEntity(
                userRepository.getById(1L)
        );
        bookRepository.save(bookEntity);
    }

    @Override
    public void saveAll(List<BookEntity> entityList) {
        bookRepository.saveAll(entityList);
    }


    @Override
    public BookEntity get(Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<BookEntity> getAll() {
        List<BookEntity> list = bookRepository.findAll();
        return list;
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> findAllByUserEntity(UserEntity userEntity) {
        return bookRepository.findAllByUserEntity(userEntity);
    }
}

package com.example.demo.book.controller;

import com.example.demo.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Runner.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAllUsers() {
    }

    @Test
    void getById() {
    }

    @Test
    void saveBook() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void deleteAllBooks() {
    }

    @Test
    void saveAllUsers() {
    }

    @Test
    void findAllByUserEntity() {
    }

    @Test
    void takeABook() {
    }

    @Test
    void returnABook() {
    }
}
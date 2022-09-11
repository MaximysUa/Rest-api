package com.example.demo.book.service;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.user.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository mockedRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void save() {
        BookEntity bookEntity = new BookEntity(1, "Gyliver",
                new UserEntity());
        ArgumentCaptor<BookEntity> argumentCaptor = ArgumentCaptor.forClass(BookEntity.class);

        this.bookService.save(bookEntity);
        verify(this.mockedRepository).save(argumentCaptor.capture());

        BookEntity value = argumentCaptor.getValue();
        assertThat(value).isEqualTo(bookEntity);
    }

    @Test
    void saveAll() {
        List<BookEntity> list = Arrays.asList(new BookEntity(1, "Gyliver",
                new UserEntity()), new BookEntity());

        ArgumentCaptor<List<BookEntity>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        this.bookService.saveAll(list);
        verify(this.mockedRepository).saveAll(argumentCaptor.capture());

        List<BookEntity> value = argumentCaptor.getValue();
        assertThat(value).isEqualTo(list);
    }

    @Test
    void get() {
        Long id = 2L;

        this.bookService.get(id);

        verify(this.mockedRepository).findById(id);
    }

    @Test
    void getAll() {
        this.bookService.getAll();

        verify(this.mockedRepository).findAll();

    }

    @Test
    void deleteAll() {
        this.bookService.deleteAll();

        verify(this.mockedRepository).deleteAll();
    }

    @Test
    void deleteById() {
        Long id = 2L;

        this.bookService.deleteById(id);

        verify(this.mockedRepository).deleteById(id);
    }

    @Test
    void findAllByUserEntity() {
        UserEntity userEntity = new UserEntity(1, "asd", "dasdas", null);

        this.bookService.findAllByUserEntity(userEntity);

        ArgumentCaptor<UserEntity> argumentCaptor = ArgumentCaptor.forClass(UserEntity.class);

        verify(this.mockedRepository).findAllByUserEntity(argumentCaptor.capture());
        UserEntity value = argumentCaptor.getValue();

        assertThat(value).isEqualTo(userEntity);

    }
}
package com.example.demo.user.entity;

import com.example.demo.book.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "user_table")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class UserEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "family_name")
    private String familyName;

    @OneToMany(mappedBy = "userEntity")
    @JsonManagedReference
    private List<BookEntity> books;
}




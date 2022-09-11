package com.example.demo.book.entity;

import com.example.demo.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "book_table")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class BookEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Nullable
    @ManyToOne
    @JsonBackReference
    private UserEntity userEntity;
}

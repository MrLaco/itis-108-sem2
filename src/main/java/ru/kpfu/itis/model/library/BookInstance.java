package ru.kpfu.itis.model.library;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book_instances")
@Data
public class BookInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    private String publisherHouse;

    private Integer publicationYear;

    @OneToOne
    @JoinColumn(name = "bookinstance_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @ManyToMany(mappedBy = "books")
    private List<Reader> readers;
}

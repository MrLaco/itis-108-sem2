package ru.kpfu.itis.model.library;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    @OneToOne(mappedBy = "book")
    private BookInstance bookInstance;
}

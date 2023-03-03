package ru.kpfu.itis.model.library;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "shelves")
@Data
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String destination;

    @OneToMany(mappedBy = "shelf", fetch = FetchType.EAGER)
    private List<BookInstance> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;
}

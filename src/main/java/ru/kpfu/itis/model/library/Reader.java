package ru.kpfu.itis.model.library;

import lombok.*;
import ru.kpfu.itis.model.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "readers")
@Data
@Builder
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "readers_books",
            joinColumns = @JoinColumn(name = "reader_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private List<Subject> books;
}

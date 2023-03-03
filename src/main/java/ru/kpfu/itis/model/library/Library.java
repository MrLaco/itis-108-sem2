package ru.kpfu.itis.model.library;

import lombok.*;
import ru.kpfu.itis.model.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "libraries")
@Data
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private List<Shelf> shelves;
}

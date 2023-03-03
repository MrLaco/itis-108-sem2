package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "subjects")
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Group> groups;
}

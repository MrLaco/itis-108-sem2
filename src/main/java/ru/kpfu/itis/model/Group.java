package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "groups")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 16)
    private String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany
    // вспомогательные мета-данные для третьей таблицы для связи m2m
    @JoinTable(
            name = "groups_subjects",
            // с одной стороны айдишник из одной сущности
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            // с другой стороны для другой сущности
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private List<Subject> subjects;
}

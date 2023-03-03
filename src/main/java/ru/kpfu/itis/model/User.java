package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private Integer experience;

    @OneToOne(mappedBy = "user")
    private Passport passport;

    // группа не будет доставаться просто при запросе юзера, это lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
}

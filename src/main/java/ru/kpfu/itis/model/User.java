package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;

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

    private String birthDate;
}

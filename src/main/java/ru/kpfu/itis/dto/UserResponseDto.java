package ru.kpfu.itis.dto;

import lombok.*;
import ru.kpfu.itis.model.*;

import java.time.LocalDate;

@Data
@Builder
public class UserResponseDto {
    private Integer id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private Integer experience;

    public static UserResponseDto fromEntity(User user) {

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .experience(user.getExperience())
                .build();
    }
}

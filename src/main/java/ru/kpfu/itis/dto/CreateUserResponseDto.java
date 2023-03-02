package ru.kpfu.itis.dto;

import lombok.*;
import ru.kpfu.itis.model.*;

import java.time.LocalDate;

@Data
@Builder
public class CreateUserResponseDto {
    private Integer id;

    private String name;

    private String email;

    private LocalDate birthDate;

    public static CreateUserResponseDto fromEntity(User user) {
        return CreateUserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .build();
    }
}

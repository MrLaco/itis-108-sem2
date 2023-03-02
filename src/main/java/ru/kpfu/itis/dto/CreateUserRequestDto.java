package ru.kpfu.itis.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Data
public class CreateUserRequestDto {
    @NotBlank(message = "Name shouldn't be blank")
    private String name;
    @NotBlank(message = "Email shouldn't be blank")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @PastOrPresent(message = "Date shouldn't be in future")
    private LocalDate birthDate;>
}

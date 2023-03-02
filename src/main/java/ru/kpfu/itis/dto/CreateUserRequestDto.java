package ru.kpfu.itis.dto;

import lombok.*;
import org.springframework.format.annotation.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class CreateUserRequestDto {
    @NotBlank(message = "Name shouldn't be blank")
    private String name;
    @NotBlank(message = "Email shouldn't be blank")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Date shouldn't be in future")
    private LocalDate birthDate;

    @NotNull
    @Min(value = 5, message = "Experience shouldn't be less than 5 years")
    private Integer experience;
}

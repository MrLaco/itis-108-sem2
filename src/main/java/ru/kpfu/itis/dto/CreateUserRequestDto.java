package ru.kpfu.itis.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class CreateUserRequestDto {
    @NotBlank(message = "Name shouldn't be blank")
    private String name;
    @NotBlank(message = "Email shouldn't be blank")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @PastOrPresent
    private String birthDate;
}

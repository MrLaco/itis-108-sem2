package ru.kpfu.itis.dto.library;

import lombok.*;
import ru.kpfu.itis.model.library.*;

@Data
@Builder
public class ReaderResponseDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    public static ReaderResponseDto fromReader(Reader reader) {

        return ReaderResponseDto.builder()
                .id(reader.getId())
                .firstName(reader.getFirstName())
                .lastName(reader.getLastName())
                .address(reader.getAddress())
                .phoneNumber(reader.getPhoneNumber())
                .build();
    }
}

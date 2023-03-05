package ru.kpfu.itis.dto.library;

import lombok.*;
import ru.kpfu.itis.model.library.*;

@Data
@Builder
public class LibraryResponseDto {

    private Integer id;

    private String name;

    private String address;

    public static LibraryResponseDto fromLibrary(Library library) {
        return LibraryResponseDto.builder()
                .id(library.getId())
                .name(library.getName())
                .address(library.getAddress())
                .build();
    }
}

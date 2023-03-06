package ru.kpfu.itis.service.library.impl;

import lombok.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.dto.library.*;
import ru.kpfu.itis.repository.library.*;
import ru.kpfu.itis.service.library.*;

@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Override
    public LibraryResponseDto getLibraryByAddress(String address) {

        LibraryResponseDto response = LibraryResponseDto.fromLibrary(
                libraryRepository.getLibraryByAddress(address));

        if (response == null) {
            throw new NullPointerException("Library is null");
        } else {
            return response;
        }
    }

    @Override
    public LibraryResponseDto getLibraryByName(String name) {

        LibraryResponseDto response = LibraryResponseDto.fromLibrary(
                libraryRepository.getLibraryByName(name)
        );

        if (response == null) {
            throw new NullPointerException("Library is null");
        } else {
            return response;
        }
    }
}

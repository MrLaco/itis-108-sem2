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
        return LibraryResponseDto.fromLibrary(
                libraryRepository.getLibraryByAddress(address)
        );
    }

    @Override
    public LibraryResponseDto getLibraryByName(String name) {
        return LibraryResponseDto.fromLibrary(
                libraryRepository.getLibraryByName(name)
        );
    }
}

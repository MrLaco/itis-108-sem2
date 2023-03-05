package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;

public interface LibraryService {

    LibraryResponseDto getLibraryByAddress(String address);
    LibraryResponseDto getLibraryByName(String name);
}

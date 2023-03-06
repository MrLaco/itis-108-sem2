package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;


public interface ShelfService {

    ShelfResponseDto findShelfByDestination(String destination);

    ShelfResponseDto findShelfByBookName(String bookName);
}

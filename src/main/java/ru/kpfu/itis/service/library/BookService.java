package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;

public interface BookService {

    BookResponseDto getBookByName(String name);
    BookResponseDto getBookByNameAndAuthor(String name, String author);
}

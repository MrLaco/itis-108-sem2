package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;

import java.util.*;

public interface BookInstanceService {

    List<BookInstanceResponseDto> findAllByAuthor(String author);
    List<BookInstanceResponseDto> findAllByName(String name);
}

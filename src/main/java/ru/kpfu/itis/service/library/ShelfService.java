package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;
import ru.kpfu.itis.model.library.*;

import java.util.*;

public interface ShelfService {

    ShelfResponseDto findShelfByDestination(String destination);
    ShelfResponseDto findShelfByBooksIn(List<BookInstance> books);

    ShelfResponseDto findShelfByBookName(String bookName);
}

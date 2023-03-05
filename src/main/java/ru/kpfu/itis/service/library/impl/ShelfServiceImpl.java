package ru.kpfu.itis.service.library.impl;

import lombok.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.dto.library.*;
import ru.kpfu.itis.model.library.*;
import ru.kpfu.itis.repository.library.*;
import ru.kpfu.itis.service.library.*;

import java.util.*;

@Service
@AllArgsConstructor
public class ShelfServiceImpl implements ShelfService {

    private final ShelfRepository shelfRepository;

    @Override
    public ShelfResponseDto findShelfByDestination(String destination) {

        return ShelfResponseDto.fromShelf(
                shelfRepository.findShelfByDestination(destination)
        );
    }

    @Override
    public ShelfResponseDto findShelfByBooksIn(List<BookInstance> books) {

        return ShelfResponseDto.fromShelf(
                shelfRepository.findShelfByBooksIn(books)
        );
    }

    @Override
    public ShelfResponseDto findShelfByBookName(String bookName) {

        return ShelfResponseDto.fromShelf(
                shelfRepository.findShelfByBookName(bookName)
        );
    }
}

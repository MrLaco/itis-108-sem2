package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import ru.kpfu.itis.model.library.*;

import java.util.*;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {

    Shelf getShelfByDestination(String destination);
    List<Shelf> getShelfByBooks(List<BookInstance> books);

//    TODO:
//    Shelf getShelfByBookName(BookInstance book);
}

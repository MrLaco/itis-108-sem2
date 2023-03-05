package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import ru.kpfu.itis.model.library.*;

import java.util.*;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {

    Shelf findShelfByDestination(String destination);
    Shelf findShelfByBooksIn(List<BookInstance> books);

    @Query(value = "select * from books where books.name like ?1", nativeQuery = true)
    Shelf findShelfByBookName(String bookName);
}

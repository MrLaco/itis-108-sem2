package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import ru.kpfu.itis.model.library.*;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book getBookByName(String name);
    Book getBookByNameAndAuthor(String name, String author);
}

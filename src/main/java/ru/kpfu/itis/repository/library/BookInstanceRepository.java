package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import ru.kpfu.itis.model.library.*;

import java.util.*;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Integer> {

    List<BookInstance> findAllByAuthor(String author);
    List<BookInstance> findAllByName(String name);
}

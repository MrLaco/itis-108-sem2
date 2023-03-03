package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import ru.kpfu.itis.model.library.*;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    Library getLibraryByAddress(String address);
    Library getLibraryByName(String name);
}

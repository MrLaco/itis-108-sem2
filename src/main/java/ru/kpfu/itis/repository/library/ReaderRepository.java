package ru.kpfu.itis.repository.library;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.model.library.*;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Reader getReaderByPhoneNumber(String phoneNumber);
    Reader getReaderByFirstNameAndLastName(String firstName, String lastName);
    Reader getReaderByAddress(String address);
}

package ru.kpfu.itis.service.library;

import ru.kpfu.itis.dto.library.*;

public interface ReaderService {

    ReaderResponseDto getReaderByPhoneNumber(String phoneNumber);
    ReaderResponseDto getReaderByFirstNameAndLastName(String firstName, String lastName);
    ReaderResponseDto getReaderByAddress(String address);
}

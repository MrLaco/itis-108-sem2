package ru.kpfu.itis.service.library.impl;

import lombok.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.dto.library.*;
import ru.kpfu.itis.repository.library.*;
import ru.kpfu.itis.service.library.*;

@Service
@AllArgsConstructor
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;


    @Override
    public ReaderResponseDto getReaderByPhoneNumber(String phoneNumber) {

        return ReaderResponseDto.fromReader(
                readerRepository.getReaderByPhoneNumber(phoneNumber)
        );
    }

    @Override
    public ReaderResponseDto getReaderByFirstNameAndLastName(String firstName, String lastName) {

        return ReaderResponseDto.fromReader(
                readerRepository.getReaderByFirstNameAndLastName(firstName, lastName)
        );
    }

    @Override
    public ReaderResponseDto getReaderByAddress(String address) {

        return ReaderResponseDto.fromReader(
                readerRepository.getReaderByAddress(address)
        );
    }
}

package ru.kpfu.itis.service.impl;

import lombok.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.dto.*;
import ru.kpfu.itis.repository.*;
import ru.kpfu.itis.service.*;

import java.util.*;
import java.util.stream.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(u -> UserResponseDto.builder()
                .name(u.getName())
                .id(u.getId())
                .email(u.getEmail())
                .birthDate(u.getBirthDate())
                .experience(u.getExperience())
                .build()
        ).collect(Collectors.toList());
    }
}

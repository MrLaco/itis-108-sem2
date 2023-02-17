package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dto.*;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.repository.*;

import javax.validation.*;
import java.util.*;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired // эта аннотация показывает, что мы внедрили зависимость в контроллер
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE: get
    @GetMapping("/create")
    public boolean createUser(@RequestParam Optional<String> name, @RequestParam Optional<String> email) {

        if (name.isPresent() && email.isPresent()) {

            User user = User
                    .builder()
                    .name(name.get())
                    .email(email.get())
                    .build();

            userRepository.save(user);

            return true;
        } else {
            return false;
        }
    }

    // READ
    @GetMapping("/users/{id}")
    public List<CreateUserResponseDto> getUser(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()))
                    .stream()
                    .map(CreateUserResponseDto::fromEntity)
                    .toList();
        } else {
            return userRepository.findAll()
                    .stream()
                    .map(CreateUserResponseDto::fromEntity)
                    .toList();
        }
    }

    // UPDATE
    @GetMapping("/update")
    public boolean updateUser(@RequestParam Optional<Integer> id, Optional<String> email, Optional<String> name, Optional<String> birthDate) {
        if (id.isPresent() && email.isPresent() && name.isPresent() && birthDate.isPresent()) {
            if (userRepository.existsById(id.get())) {
                User oldUser = userRepository.findById(id.get()).get();
                oldUser.setName(name.get());
                oldUser.setEmail(email.get());
                oldUser.setBirthDate(birthDate.get());
                userRepository.save(oldUser);

                return true;
            }
        }
        return false;
    }

    // DELETE
    @GetMapping("/delete")
    public boolean deleteUser(@RequestParam Optional<Integer> id) {
        if (id.isPresent()) {
            if (userRepository.existsById(id.get())) {
                userRepository.deleteById(id.get());
            }
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("Ivan"));
    }

    // CREATE: post
    @PostMapping("/user")
    public CreateUserResponseDto createUser(@Valid @RequestBody CreateUserRequestDto user) {

        return CreateUserResponseDto.fromEntity(userRepository.save(
                User.builder()
                        .name(user.getName().trim()) // trim просто для того, чтоб показать, что тут
                        .email(user.getEmail().trim()) // логику можно делать, но лучше такое в репозитории
                        .birthDate(user.getBirthDate().trim())
                        .build()
        ));
    }
}

// для создания/выдачи пользователя используется дто
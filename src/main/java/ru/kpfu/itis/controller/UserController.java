package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.*;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.repository.*;
import ru.kpfu.itis.service.*;

import javax.validation.*;
import java.time.LocalDate;
import java.util.*;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired // эта аннотация показывает, что мы внедрили зависимость в контроллер
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE: get
    @GetMapping("/create")
    public boolean createUser(
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> email,
            @RequestParam Optional<LocalDate> birthDate,
            @RequestParam Optional<Integer> experience
    ) {

        if (name.isPresent() && email.isPresent() && birthDate.isPresent() && experience.isPresent()) {

            User user = User
                    .builder()
                    .name(name.get())
                    .email(email.get())
                    .birthDate(birthDate.get())
                    .experience(experience.get())
                    .build();

            userRepository.save(user);

            return true;
        } else {
            return false;
        }
    }

    // READ
    @GetMapping("/users/{id}")
    public List<UserResponseDto> getUser(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()))
                    .stream()
                    .map(UserResponseDto::fromEntity)
                    .toList();
        } else {
            return userService.findAll();
        }
    }

    // UPDATE
    @GetMapping("/update")
    public boolean updateUser(
            @RequestParam Optional<Integer> id,
            Optional<String> email,
            Optional<String> name,
            Optional<LocalDate> birthDate,
            Optional<Integer> experience
    ) {
        if (id.isPresent() && email.isPresent() && name.isPresent() && birthDate.isPresent() && experience.isPresent()) {
            if (userRepository.existsById(id.get())) {
                User oldUser = userRepository.findById(id.get()).get();
                oldUser.setName(name.get());
                oldUser.setEmail(email.get());
                oldUser.setBirthDate(birthDate.get());
                oldUser.setExperience(experience.get());
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
    @PostMapping("/")
    public UserResponseDto createUser(@Valid @ModelAttribute("User") UserRequestDto user) {

        return UserResponseDto.fromEntity(
                userRepository.save(
                    User.builder()
                        .name(user.getName().trim())
                        .email(user.getEmail().trim())
                        .birthDate(user.getBirthDate())
                        .experience(user.getExperience())
                        .build()
                )
        );
    }

    @GetMapping("/")
    public ModelAndView showCreateUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}

package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.repository.*;

import java.util.*;

@RestController
public class HelloController {

    private final UserRepository userRepository;

    @Autowired // эта аннотация показывает, что мы внедрили зависимость в контроллер
    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    @GetMapping("/create")
    public boolean createUser(@RequestParam Optional<String> name, @RequestParam Optional<String> email) {

        if (name.isPresent() && email.isPresent()) {

            User user = new User();

            user.setName(name.get());
            user.setEmail(email.get());

            userRepository.save(user);

            return true;
        } else {
            return false;
        }
    }

    // READ
    @GetMapping("/users/{id}")
    public Iterable<User> getUser(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()));
        } else {
            return userRepository.findAll();
        }
    }

    // UPDATE
    @GetMapping("/update")
    public boolean updateUser(@RequestParam Optional<Integer> id, Optional<String> email, Optional<String> name) {
        if (id.isPresent() && email.isPresent() && name.isPresent()) {
            if (userRepository.existsById(id.get())) {
                User oldUser = userRepository.findById(id.get()).get();
                oldUser.setName(name.get());
                oldUser.setEmail(email.get());
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
}

// task: эндоинт на создание, удаление по айдишнику и обновление
// рид уже есть
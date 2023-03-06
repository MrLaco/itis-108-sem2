package ru.kpfu.itis.controller.library;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dto.library.*;
import ru.kpfu.itis.exceptions.*;
import ru.kpfu.itis.model.library.*;
import ru.kpfu.itis.repository.library.*;
import ru.kpfu.itis.service.library.*;
import ru.kpfu.itis.service.library.impl.*;

import java.util.*;

@RestController
public class ShelfController {

    private final ShelfService shelfService;
    private final ShelfRepository shelfRepository;

    @Autowired
    public ShelfController(ShelfServiceImpl shelfService, ShelfRepository shelfRepository) {
        this.shelfService = shelfService;
        this.shelfRepository = shelfRepository;
    }

    @GetMapping("/service/shelf/create")
    public boolean createShelf(
            @RequestParam Optional<String> destination,
            @RequestParam Optional<String> name,
            @RequestParam Optional<Library> library
    ) {
        if (destination.isPresent() && name.isPresent() && library.isPresent()) {
            Shelf shelf = Shelf.builder()
                    .destination(destination.get())
                    .name(name.get())
                    .library(library.get())
                    .build();
            shelfRepository.save(shelf);

            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/service/bookinstance/get")
    public ShelfResponseDto getShelfByDestinationOrByBookName(
            @RequestParam Optional<String> destination,
            @RequestParam Optional<String> name
    ) throws InvalidArgumentException {

        if (destination.isPresent() && name.isPresent()) {
            throw new InvalidArgumentException("Ты чорт, вводи правильные аргументы в query");
        } else if (destination.isPresent()) {
            return shelfService.findShelfByDestination(destination.get());
        } else if (name.isPresent()) {
            return shelfService.findShelfByBookName(name.get());
        } else {
            throw new InvalidArgumentException("Ты чорт, вводи правильные аргументы в query");
        }
    }
}

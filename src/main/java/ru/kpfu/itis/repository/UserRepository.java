package ru.kpfu.itis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import ru.kpfu.itis.model.*;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

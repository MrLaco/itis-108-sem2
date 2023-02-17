package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

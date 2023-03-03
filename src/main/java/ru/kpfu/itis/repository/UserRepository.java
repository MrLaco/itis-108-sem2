package ru.kpfu.itis.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.model.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);
    List<User> findAllByIdInAndEmailNotNull(List<Integer> ids);

    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from users where u.name like ?1", nativeQuery = true) // назание параметра через ?№
    List<User> findAllByName(String name);

    @Query("select u from User u where u.email = :email") // название параметра через :
    List<User> findAllByEmail(String email);

    @Query(value = "select u from User u where u.name = :name and u.id = :id")
    User findUserByNameAndId(@Param("name") String name, @Param("id") String id);

    @Query(value = "select u from User u where u.id in :ids")
    List<User> findAllByIds(@Param("ids") List<Integer> ids);
}

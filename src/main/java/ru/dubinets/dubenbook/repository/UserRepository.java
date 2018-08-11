package ru.dubinets.dubenbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dubinets.dubenbook.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User        findByEmail(String email);
    User        findByUsername(String username);
    List<User>  findAll();

}

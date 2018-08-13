package ru.dubinets.dubenbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.model.User;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile         findByUser(User user);
    List<Profile>   findAll();
}

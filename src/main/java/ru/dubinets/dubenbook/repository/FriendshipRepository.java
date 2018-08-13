package ru.dubinets.dubenbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dubinets.dubenbook.model.Friendship;
import ru.dubinets.dubenbook.model.Profile;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    List<Friendship>        findFriendshipsByProfile1(Profile profile1);

    List<Friendship>        findAll();
}

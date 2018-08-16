package ru.dubinets.dubenbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dubinets.dubenbook.model.Message;
import ru.dubinets.dubenbook.model.Profile;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message>      findByProfile1(Profile me);
    List<Message>      findByProfile1AndProfile2OrderByDatetime(Profile me, Profile mate);
    List<Message>      findByProfile1AndProfile2OrProfile2AndProfile1OrderByDatetime(Profile me, Profile mate, Profile me2, Profile mate2);

}

package ru.dubinets.dubenbook.service;

import ru.dubinets.dubenbook.model.Message;
import ru.dubinets.dubenbook.model.Profile;

import java.util.List;

public interface MessageService {

    List<Message>      findByProfile1(Profile me);
    List<Message>      findByProfile1AndProfile2OrderByDatetime(Profile me, Profile mate);
    List<Message>      findAllMessagesBetweenMeAndMateOrderByDatetime(Profile me, Profile mate);

    void            saveMessage(Message message);

}

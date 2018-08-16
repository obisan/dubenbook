package ru.dubinets.dubenbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubinets.dubenbook.model.Message;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.repository.MessageRepository;
import ru.dubinets.dubenbook.repository.ProfileRepository;
import ru.dubinets.dubenbook.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Message> findByProfile1(Profile me) {
        return messageRepository.findByProfile1(me);
    }

    @Override
    public List<Message> findByProfile1AndProfile2OrderByDatetime(Profile me, Profile mate) {
        return messageRepository.findByProfile1AndProfile2OrderByDatetime(me, mate);
    }

    @Override
    public List<Message> findAllMessagesBetweenMeAndMateOrderByDatetime(Profile me, Profile mate) {
        return messageRepository.findByProfile1AndProfile2OrProfile2AndProfile1OrderByDatetime(me, mate, me, mate);
    }

    @Override
    public void saveMessage(Message message) {
        Profile me      = userRepository.findByUsername(message.getProfile1().getUser().getUsername()).getProfile();
        Profile mate    = userRepository.findByUsername(message.getProfile2().getUser().getUsername()).getProfile();

        message.setProfile1(me);
        message.setProfile2(mate);

        Timestamp datetime = new Timestamp(new Date().getTime());
        message.setDatetime(datetime);

        messageRepository.save(message);
    }
}

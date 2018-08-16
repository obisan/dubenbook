package ru.dubinets.dubenbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubinets.dubenbook.model.Message;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.repository.MessageRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findByProfile1(Profile me) {
        return messageRepository.findByProfile1(me);
    }

    @Override
    public List<Message> findByProfile1AndProfile2OrderByDatetime(Profile me, Profile mate) {
        return messageRepository.findByProfile1AndProfile2OrderByDatetime(me, mate);
    }

    @Override
    public void saveChat(Message message) {
        Timestamp datetime = new Timestamp(new Date().getTime());

        message.setDatetime(datetime);

        Message messageMate = new Message();
        messageMate.setProfile1(message.getProfile2());
        messageMate.setProfile2(message.getProfile1());
        messageMate.setText(message.getText());
        messageMate.setDatetime(datetime);

        messageRepository.save(message);
        messageRepository.save(messageMate);
    }
}

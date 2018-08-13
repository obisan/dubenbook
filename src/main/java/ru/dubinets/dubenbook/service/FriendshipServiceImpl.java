package ru.dubinets.dubenbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubinets.dubenbook.model.Friendship;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.repository.FriendshipRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Override
    public List<Profile> getAllFriends(Profile me) {

        List<Profile> friends = new ArrayList<>();
        for(Friendship friendship : friendshipRepository.findFriendshipsByProfile1(me)) {
            friends.add(friendship.getProfile2());
        }

        return friends;
    }

    @Override
    public void addFriend(Profile me, Profile user) {

        Friendship friendship1 = new Friendship(me, user, "accepted");
        Friendship friendship2 = new Friendship(user, me, "accepted");

        friendshipRepository.save(friendship1);
        friendshipRepository.save(friendship2);
    }
}

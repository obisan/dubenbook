package ru.dubinets.dubenbook.service;

import ru.dubinets.dubenbook.model.Profile;

import java.util.List;

public interface FriendshipService {

    List<Profile>       getAllFriends(Profile me);

    void                addFriend(Profile me, Profile user);

}

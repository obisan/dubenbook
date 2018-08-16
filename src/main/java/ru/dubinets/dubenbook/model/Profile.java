package ru.dubinets.dubenbook.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "city")
    private String city;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "profile1"
    )
    private Friendship friendship1;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "profile2"
    )
    private Friendship friendship2;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "profile1"
    )
    private Set<Message> messages1;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "profile2"
    )
    private Set<Message> messages2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Friendship getFriendship1() {
        return friendship1;
    }

    public void setFriendship1(Friendship friendship1) {
        this.friendship1 = friendship1;
    }

    public Friendship getFriendship2() {
        return friendship2;
    }

    public void setFriendship2(Friendship friendship2) {
        this.friendship2 = friendship2;
    }

    public Set<Message> getMessages1() {
        return messages1;
    }

    public void setMessages1(Set<Message> messages1) {
        this.messages1 = messages1;
    }

    public Set<Message> getMessages2() {
        return messages2;
    }

    public void setMessages2(Set<Message> messages2) {
        this.messages2 = messages2;
    }
}

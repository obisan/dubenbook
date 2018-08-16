package ru.dubinets.dubenbook.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "profile1_id",
            nullable = false
    )
    private Profile profile1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "profile2_id",
            nullable = false
    )
    private Profile profile2;

    @Column(name = "text")
    private String text;

    @Column(name = "datetime")
    private Timestamp datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }

    public Profile getProfile2() {
        return profile2;
    }

    public void setProfile2(Profile profile2) {
        this.profile2 = profile2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}

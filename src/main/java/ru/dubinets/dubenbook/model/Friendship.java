package ru.dubinets.dubenbook.model;

import javax.persistence.*;

@Entity
@Table(name = "friendship")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "profile1_id",
            nullable = false
    )
    private Profile profile1;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "profile2_id",
            nullable = false
    )
    private Profile profile2;

    @Column(name = "status")
    private String status;

    public Friendship() {
    }

    public Friendship(Profile profile1, Profile profile2, String status) {
        this.profile1 = profile1;
        this.profile2 = profile2;
        this.status = status;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

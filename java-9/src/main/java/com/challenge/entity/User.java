package com.challenge.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fullName;
    private String nickName;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "submission",
    joinColumns = {@JoinColumn(columnDefinition = "user")},
    inverseJoinColumns = {@JoinColumn(columnDefinition = "challengeId")})
    List<Challenge> challenges = new ArrayList<>();


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }
}

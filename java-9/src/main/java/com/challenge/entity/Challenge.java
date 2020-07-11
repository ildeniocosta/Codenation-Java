package com.challenge.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String slug;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
    @ManyToMany
    List<User> users = new ArrayList<>();


}

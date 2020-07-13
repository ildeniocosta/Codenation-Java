package com.challenge.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(length = 100)
    private String email;
    @Column(length = 50)
    private String nickname;
    @Column(length = 200)
    private String password;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToMany
    private List<Candidate> candidates;
    @OneToMany
    private List<Submission> submissions;


}
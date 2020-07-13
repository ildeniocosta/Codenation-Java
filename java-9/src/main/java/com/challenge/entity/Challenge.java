package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "challenge")
@Setter
@Getter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Column(length = 50)
    private String slug;
    @Column(name = "created_at", length = 100)
    private LocalDateTime createdAt;
    @OneToMany
    private List<Submission> submissions;


}
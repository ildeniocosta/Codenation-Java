package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String slug;
    private LocalDateTime creatAt;


}

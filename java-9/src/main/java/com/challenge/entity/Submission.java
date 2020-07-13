package com.challenge.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Submission {
    @EmbeddedId
    private SubmissionId id;

    @MapsId
    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User userId;
    @MapsId
    @OneToMany
    @JoinColumn(name="challenge_id", referencedColumnName="id")
    private Challenge challengeId;




    private Double score;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;

}
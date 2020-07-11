package com.challenge.entity;

import javax.persistence.*;
import java.util.Calendar;


public class Submission {

    private User userId;

    private Challenge challengeId;




    private Double score;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;

}

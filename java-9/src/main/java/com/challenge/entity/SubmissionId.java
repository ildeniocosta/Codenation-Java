package com.challenge.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubmissionId implements Serializable {
    private Integer userId;
    private Integer challengeId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userid) {
        this.userId = userid;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }
}

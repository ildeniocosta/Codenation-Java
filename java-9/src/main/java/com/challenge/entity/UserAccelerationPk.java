package com.challenge.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAccelerationPk implements Serializable {
    private Integer userId;
    private Integer accelerationId;
    private Integer companyId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccelerationId() {
        return accelerationId;
    }

    public void setAccelerationId(Integer accelerationId) {
        this.accelerationId = accelerationId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}

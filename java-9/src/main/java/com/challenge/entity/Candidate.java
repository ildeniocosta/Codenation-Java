package com.challenge.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate")
@Getter
@Setter
public class Candidate {
    @EmbeddedId
    private UserAccelerationPk userAcceleratioPk;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    @MapsId("accelerationId")
    @ManyToOne
    @JoinColumn(name="acceleration_id", referencedColumnName="id")
    private Acceleration acceleration;

    @MapsId("companyId")
    @ManyToOne
    @JoinColumn(name="company_id", referencedColumnName="id")
    private Company company;

    private Integer status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
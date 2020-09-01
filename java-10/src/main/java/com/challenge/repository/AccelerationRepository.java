package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration,Long> {
    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

    Optional<Acceleration> findByName(String name);

}

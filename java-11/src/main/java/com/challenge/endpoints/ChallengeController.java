package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> buscarPeloAccelerationIdAndUserId(
            @RequestParam(name = "accelerationId") Long accelerationId,
            @RequestParam(name = "userId") Long userId) {
        return ResponseEntity.ok(challengeService.findByAccelerationIdAndUserId(accelerationId, userId));
    }
}

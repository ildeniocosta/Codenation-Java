package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> buscaPeloId(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "companyId") Long companyId,
            @PathVariable(value = "accelerationId") Long accelerationId) {

        return ResponseEntity.ok()
                .body(candidateMapper.map(candidateService.findById(userId, companyId, accelerationId)
                        .orElse(new Candidate())));
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> buscaPeloCompanyIdOuAccelerationId(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {

        List<Candidate> candidates = new ArrayList<>();
        if (companyId != 0) candidates.addAll(candidateService.findByCompanyId(companyId));
        if (accelerationId != 0) candidates.addAll(candidateService.findByAccelerationId(accelerationId));

        if (candidates.isEmpty()) {
            ResponseEntity.ok(new ArrayList<>());
        }

        return ResponseEntity.ok().body(candidateMapper.map(candidates));
    }
}

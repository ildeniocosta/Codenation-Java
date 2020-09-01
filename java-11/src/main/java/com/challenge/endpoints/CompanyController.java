package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    private ResponseEntity<Company> buscarPeloId(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        return ResponseEntity.ok(company.get());
    }

    @GetMapping
    private ResponseEntity<List<Company>> buscarPelaAccelerationId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long userId
    ) {
        List<Company> companies = null;

        if (accelerationId != null && userId == null) {
            companies = companyService.findByAccelerationId(accelerationId);
        } else if (accelerationId == null && userId != null) {
            companies = companyService.findByUserId(userId);
        }

        return ResponseEntity.ok(companies);
    }


}

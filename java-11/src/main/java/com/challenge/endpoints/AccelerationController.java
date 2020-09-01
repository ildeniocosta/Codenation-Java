package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
    @Autowired
    private AccelerationService accelerationService;
    @GetMapping("/{id}")
    private ResponseEntity<Acceleration> buscarPeloId(@PathVariable Long id) {
        Optional<Acceleration> acceleration = accelerationService.findById(id);
        return ResponseEntity.ok(acceleration.get());
    }

    @GetMapping
    private ResponseEntity<List<Acceleration>> buscarTodosPeloCompanyId(@RequestParam Long companyId) {
        return ResponseEntity.ok(accelerationService.findByCompanyId(companyId));
    }
}

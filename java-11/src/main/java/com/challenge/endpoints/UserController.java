package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.ok(user.get());
    }
    @GetMapping
    private ResponseEntity<List<User>> buscarPelaaccelerationName(
            @RequestParam(required = false) String accelerationName,
            @RequestParam(required = false, name = "companyId") Long companyId
    ) {
        List<User> users = null;

        if (accelerationName != null && companyId == null) {
            users = userService.findByAccelerationName(accelerationName);
        } else if (accelerationName == null && companyId != null) {
            users = userService.findByCompanyId(companyId);
        }

        return ResponseEntity.ok(users);
    }

}

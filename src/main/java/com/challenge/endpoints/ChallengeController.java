package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeServiceInterface;

    @GetMapping
    List<Challenge> findByAccelerationIdAndUserId(@RequestParam Long accelerationId, @RequestParam Long userId) {
        return this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}

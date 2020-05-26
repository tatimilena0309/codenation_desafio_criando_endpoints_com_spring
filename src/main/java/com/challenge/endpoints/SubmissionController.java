package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;
    @Autowired
    private SubmissionMapper submissionMapper;

    public SubmissionController(SubmissionService submissionServiceInterface) {
        this.submissionServiceInterface = submissionServiceInterface;
    }

    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(
            @RequestParam(required = false) Long challengeId,
            @RequestParam(required = false) Long accelerationId) {
        return submissionMapper.map(submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}

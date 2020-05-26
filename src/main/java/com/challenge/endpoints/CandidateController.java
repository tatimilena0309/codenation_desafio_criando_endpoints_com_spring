package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;

import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateServiceInterface candidateService;
    @Autowired
    private CandidateMapper candidateMapper;

    public CandidateController(CandidateServiceInterface candidateService, CandidateMapper candidateMapper) {
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }


    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public CandidateDTO findById(
            @PathVariable("userId") Long userId,
            @PathVariable("companyId") Long companyId,
            @PathVariable("accelerationId") Long accelerationId) {
        return candidateMapper.map(candidateService.findById(userId, companyId, accelerationId).orElse(new Candidate()));
    }

    @GetMapping
    public List<CandidateDTO> findByCompanyIdOrAccelerationId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long companyId) {
        if (companyId != null) {
            return this.candidateMapper.map(candidateService.findByCompanyId(companyId));
        } else if (accelerationId != null) {
            return this.candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
        } else {
            return Collections.emptyList();
        }
    }
}


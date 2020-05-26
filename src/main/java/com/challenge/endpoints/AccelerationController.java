package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/acceleration")

public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    @GetMapping("/{id}")
    public Acceleration findById(@PathVariable("id") Long id) {
        return this.accelerationServiceInterface.findById(id).get();
    }

    @GetMapping
    public List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
        return this.accelerationServiceInterface.findByCompanyId(companyId);
    }

}
package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return this.companyServiceInterface.findById(id).get();
    }

    @GetMapping
    public List<Company> listByAccelerationIdOrUserId(@RequestParam(required = false) Long accelerationId,
                                                      @RequestParam(required = false)  Long userId) {
        if (accelerationId != null) {
            return this.companyServiceInterface.findByAccelerationId(accelerationId);
        } else if (userId != null) {
            return this.companyServiceInterface.findByUserId(userId);
        } else {
            return Collections.emptyList();
        }
    }

}

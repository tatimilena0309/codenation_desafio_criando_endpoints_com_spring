package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<Optional<User>>(this.userService.findById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(@RequestParam(required = false) String accelerationName,
                                                       @RequestParam(required = false) Long companyId) {
        if (accelerationName != null) {
            return new ResponseEntity<List<User>>(this.userService.findByAccelerationName(accelerationName), HttpStatus.OK);
        } else if (companyId != null) {
            return new ResponseEntity<List<User>>(this.userService.findByCompanyId(companyId), HttpStatus.OK);
        }else{
         return new ResponseEntity<List<User>> (Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }

}

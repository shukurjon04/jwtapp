package com.example.jwtapp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ResponseEntity getMethodName() {
        return ResponseEntity.ok("welcome");
    }
    

}

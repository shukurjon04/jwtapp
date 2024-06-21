package com.example.jwtapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtapp.Dto.UserDto;
import com.example.jwtapp.Security.JwtProvider;
import com.example.jwtapp.Security.MyAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    MyAuthService authService;

    @Autowired
    JwtProvider provider;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;    


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
    try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        return ResponseEntity.ok(provider.generateToken(userDto.getUsername()));
    }catch(Exception e){
        return ResponseEntity.notFound().build();

    }
//        UserDetails userByUsername = authService.loadUserByUsername(userDto.getUsername());
//        if(java.util.Objects.nonNull(userByUsername)){
//            if(encoder.matches(userDto.getPassword(), userByUsername.getPassword())){
//                return ResponseEntity.ok(provider.generateToken(userByUsername.getUsername()));
//            }
//        }
//        return ResponseEntity.notFound().build();
    }

}

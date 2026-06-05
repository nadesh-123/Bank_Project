package com.HireTrack.controller;

import com.HireTrack.dto.TokenDto;
import com.HireTrack.utility.JwtUtility;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final  JwtUtility jwtUtility;
    @PostMapping("/login")
    public TokenDto login(Principal principal){
        String username=principal.getName();
        String token=jwtUtility.generateToken(username);
        return  new TokenDto(username,token);
    }

}

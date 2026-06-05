package com.HireTrack.mapper;

import com.HireTrack.dto.EmployerPostDto;
import com.HireTrack.dto.SeekerPostDto;
import com.HireTrack.enums.Role;
import com.HireTrack.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    PasswordEncoder passwordEncoder;
    public User mapDtoToUser(EmployerPostDto employerPostDto){
        User user=new User();
        user.setUsername(employerPostDto.username());
        user.setRole(Role.EMPLOYER);
        user.setPassword(passwordEncoder.encode(employerPostDto.password()));
        return  user;
    }
    public User mapDtoToSeekerUser(SeekerPostDto seekerPostDto){
        User user=new User();
        user.setPassword(passwordEncoder.encode(seekerPostDto.password()));
        user.setRole(Role.SEEKER);
        user.setUsername(seekerPostDto.username());
        return  user;
    }
}

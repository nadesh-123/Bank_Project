package com.HireTrack.service;

import com.HireTrack.dto.SeekerPostDto;
import com.HireTrack.exception.ResourceNotFoundException;
import com.HireTrack.mapper.SeekerMapper;
import com.HireTrack.mapper.UserMapper;
import com.HireTrack.model.Seeker;
import com.HireTrack.model.User;
import com.HireTrack.repository.SeekerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeekerService {
    private final  UserMapper userMapper;
    private final  SeekerMapper seekerMapper;
    private final  UserService userService;
    private final  SeekerRepository seekerRepository;


    public void postSeeker(SeekerPostDto seekerPostDto) {
        User user =userMapper.mapDtoToSeekerUser(seekerPostDto);
        userService.saveUser(user);
        Seeker seeker=seekerMapper.mapDtoToSeeker(seekerPostDto);
        seeker.setUser(user);
        seekerRepository.save(seeker);

    }



    public Seeker findByUserUsername(String username) {
        return  seekerRepository.findByUserUsername(username).orElseThrow(()->new ResourceNotFoundException("invalid user name"));
    }
}

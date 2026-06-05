package com.HireTrack.service;

import com.HireTrack.dto.EmployerPostDto;
import com.HireTrack.mapper.EmployerMapper;
import com.HireTrack.mapper.UserMapper;
import com.HireTrack.model.Employer;
import com.HireTrack.model.User;
import com.HireTrack.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;
    private final UserMapper userMapper;
    private final UserService userService;
    public void postEmployer(EmployerPostDto employerPostDto) {
        User user=userMapper.mapDtoToUser(employerPostDto);
        userService.saveUser(user);
        Employer employer=employerMapper.mapToEmployer(employerPostDto);
        employer.setUser(user);
        employerRepository.save(employer);
    }

    public Employer getEmployerByUsername(String username) {
       return employerRepository.findByUserUsername(username);
    }
}

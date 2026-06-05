package com.HireTrack.mapper;

import com.HireTrack.dto.EmployerPostDto;
import com.HireTrack.model.Employer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployerMapper {
    public Employer mapToEmployer(EmployerPostDto employerPostDto){
        Employer employer=new Employer();
        employer.setCompanyName(employerPostDto.companyName());
        return employer;
    }
}

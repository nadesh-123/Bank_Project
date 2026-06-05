package com.HireTrack.mapper;

import com.HireTrack.dto.ApplicationResponse;
import com.HireTrack.model.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {
    public ApplicationResponse mapToDto(Application application){
        return  new ApplicationResponse(application.getId(),
                application.getAppliedAt(),
                application.getJob().getTitle()
                ,application.getJob().getEmployer().getCompanyName());
    }
}

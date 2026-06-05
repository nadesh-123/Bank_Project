package com.HireTrack.service;

import com.HireTrack.dto.ApplicationResponse;
import com.HireTrack.mapper.ApplicationMapper;
import com.HireTrack.model.Application;
import com.HireTrack.model.Job;
import com.HireTrack.model.Seeker;
import com.HireTrack.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final  ApplicationRepository applicationRepository;
    private final   SeekerService seekerService;
    private final JobService jobService;
    private final ApplicationMapper applicationMapper;
    public void saveApplication(String username,int jobId) {
        Seeker seeker=  seekerService.findByUserUsername(username);
        Job job=jobService.getById(jobId);
        Application application=new Application();
        application.setJob(job);
        application.setSeeker(seeker);
        applicationRepository.save(application);
    }

    public List<ApplicationResponse> findMyApplications(String username, int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        List<Application> list=applicationRepository.findBySeekerUserUsername(username,pageable).getContent();
       return list.stream().map(applicationMapper::mapToDto).toList();
    }
}

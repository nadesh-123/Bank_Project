package com.HireTrack.mapper;

import com.HireTrack.dto.JobResponse;
import com.HireTrack.dto.CreateJobRequest;
import com.HireTrack.model.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public Job mapDtoJob(CreateJobRequest jobPostDto){
        Job job=new Job();
        job.setDescription(jobPostDto.description());
        job.setTitle(jobPostDto.title());
        job.setLocation(jobPostDto.location());
        job.setSalary(jobPostDto.salary());
        return  job;
    }
public JobResponse mapToDto(Job job){
        return  new JobResponse(job.getId(),job.getTitle(),job.getLocation(),job.getSalary(),job.getEmployer().getCompanyName());
}
}

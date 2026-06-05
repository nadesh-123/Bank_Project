package com.HireTrack.service;

import com.HireTrack.dto.JobResponse;
import com.HireTrack.dto.CreateJobRequest;
import com.HireTrack.exception.ResourceNotFoundException;
import com.HireTrack.mapper.JobMapper;
import com.HireTrack.model.Employer;
import com.HireTrack.model.Job;
import com.HireTrack.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
    private final EmployerService employerService;
    private final JobMapper jobMapper;
    private final JobRepository jobRepository;
    public void saveJob(String username, CreateJobRequest jobPostDto) {
       Employer employer= employerService.getEmployerByUsername(username);
       Job job=jobMapper.mapDtoJob(jobPostDto);
       job.setEmployer(employer);
       jobRepository.save(job);
    }

    public List<JobResponse> getAllJobs(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
       List<Job> list= jobRepository.findAll(pageable).getContent();
       return list.stream().map(jobMapper::mapToDto).toList();
    }

    public Job getById(int jobId) {
        return jobRepository.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Invalid job id"));
    }
}

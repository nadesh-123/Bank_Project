package com.HireTrack.mapper;

import com.HireTrack.dto.SeekerPostDto;
import com.HireTrack.model.Seeker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SeekerMapper {
    public Seeker mapDtoToSeeker(SeekerPostDto seekerPostDto){
        Seeker seeker=new Seeker();
        seeker.setEmail(seekerPostDto.email());
        seeker.setName(seekerPostDto.name());
        seeker.setResumeSummary(seekerPostDto.resumeSummary());
        return  seeker;

    }
}

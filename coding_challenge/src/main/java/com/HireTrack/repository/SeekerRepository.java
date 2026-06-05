package com.HireTrack.repository;

import com.HireTrack.model.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeekerRepository extends JpaRepository<Seeker,Integer> {
    Optional<Seeker> findByUserUsername(String username);
}

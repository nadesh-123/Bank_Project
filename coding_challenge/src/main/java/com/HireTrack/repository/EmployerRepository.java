package com.HireTrack.repository;

import com.HireTrack.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Integer> {
//    @Query("""
//            select e from Employer e
//            where e.User.Username=?1
//            """)
//    Employer getEmployerByUsername(String username);

    Employer findByUserUsername(String username);
}

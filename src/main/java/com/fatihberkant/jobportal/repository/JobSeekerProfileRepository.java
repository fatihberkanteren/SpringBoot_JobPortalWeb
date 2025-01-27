package com.fatihberkant.jobportal.repository;

import com.fatihberkant.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}

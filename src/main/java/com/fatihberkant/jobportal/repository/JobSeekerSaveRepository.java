package com.fatihberkant.jobportal.repository;

import com.fatihberkant.jobportal.entity.JobPostActivity;
import com.fatihberkant.jobportal.entity.JobSeekerProfile;
import com.fatihberkant.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);
}

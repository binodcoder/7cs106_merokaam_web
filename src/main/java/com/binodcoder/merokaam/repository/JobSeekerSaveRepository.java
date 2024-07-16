package com.binodcoder.merokaam.repository;
import com.binodcoder.merokaam.entity.JobPostActivity;
import com.binodcoder.merokaam.entity.JobSeekerProfile;
import com.binodcoder.merokaam.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {
    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);
    List<JobSeekerSave> findByJob(JobPostActivity job);
}

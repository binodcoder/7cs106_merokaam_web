package com.binodcoder.merokaam.repository;
import com.binodcoder.merokaam.entity.JobPostActivity;
import com.binodcoder.merokaam.entity.JobSeekerApply;
import com.binodcoder.merokaam.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {
    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);

}

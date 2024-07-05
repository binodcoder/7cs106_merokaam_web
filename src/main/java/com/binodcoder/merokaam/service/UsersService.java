package com.binodcoder.merokaam.service;
import com.binodcoder.merokaam.entity.JobSeekerProfile;
import com.binodcoder.merokaam.entity.RecruiterProfile;
import com.binodcoder.merokaam.entity.Users;
import com.binodcoder.merokaam.repository.JobSeekerProfileRepository;
import com.binodcoder.merokaam.repository.RecruiterProfileRepository;
import com.binodcoder.merokaam.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUsers = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
        }
        return savedUsers;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
package com.binodcoder.merokaam.service;
import com.binodcoder.merokaam.entity.RecruiterProfile;
import com.binodcoder.merokaam.entity.Users;
import com.binodcoder.merokaam.repository.RecruiterProfileRepository;
import com.binodcoder.merokaam.repository.UsersRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {

    private final RecruiterProfileRepository recruiterProfileRepository;
    private final UsersRepository usersRepository;

    public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository, UsersRepository usersRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersRepository = usersRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id){
        return recruiterProfileRepository.findById(id);
    }

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }

    public RecruiterProfile getCurrentRecruiterProfile() {
      Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
      if(!(authentication instanceof AnonymousAuthenticationToken)){
          String currentUsername=authentication.getName();
        Users users= usersRepository.findByEmail(currentUsername).orElseThrow(()-> new UsernameNotFoundException("User not "+ "found"));
       Optional<RecruiterProfile> recruiterProfile=   getOne(users.getUserId());
       return  recruiterProfile.orElseThrow(null);
      }else return null;
    }
}

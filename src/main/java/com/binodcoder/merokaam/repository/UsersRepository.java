package com.binodcoder.merokaam.repository;
import com.binodcoder.merokaam.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}

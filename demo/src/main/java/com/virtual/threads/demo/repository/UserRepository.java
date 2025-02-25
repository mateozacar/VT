package com.virtual.threads.demo.repository;

import com.virtual.threads.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
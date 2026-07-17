package com.fernandocalisto.MovieFlix.repository;

import com.fernandocalisto.MovieFlix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

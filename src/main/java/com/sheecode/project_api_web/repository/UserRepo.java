package com.sheecode.project_api_web.repository;

import com.sheecode.project_api_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}

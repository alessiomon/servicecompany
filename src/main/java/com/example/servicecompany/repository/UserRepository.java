package com.example.servicecompany.repository;

import com.example.servicecompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}

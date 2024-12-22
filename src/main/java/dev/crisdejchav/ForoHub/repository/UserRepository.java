package dev.crisdejchav.ForoHub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import dev.crisdejchav.ForoHub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByEmail(String email);

}
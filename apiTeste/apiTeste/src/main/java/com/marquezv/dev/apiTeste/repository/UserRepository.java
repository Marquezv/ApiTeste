package com.marquezv.dev.apiTeste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marquezv.dev.apiTeste.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}

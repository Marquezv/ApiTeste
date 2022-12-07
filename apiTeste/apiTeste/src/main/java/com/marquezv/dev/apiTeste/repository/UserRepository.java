package com.marquezv.dev.apiTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marquezv.dev.apiTeste.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
		
}

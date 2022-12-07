package com.marquezv.dev.apiTeste.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.repository.UserRepository;


@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB() {
		User user1 = new  User((long) 1, "Vini", "vini@gmail.com", "123");
		User user2 = new  User((long) 2, "Lua", "lua@gmail.com", "12");
		
		repository.saveAll(List.of(user1, user2));
		
	}
	
}

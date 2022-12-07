package com.marquezv.dev.apiTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.exceptions.ObjectNotFoundException;
import com.marquezv.dev.apiTeste.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(
						() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public List<User> findAll() {
		return repository.findAll();
	}
}

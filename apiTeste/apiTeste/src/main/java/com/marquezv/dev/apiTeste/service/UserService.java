package com.marquezv.dev.apiTeste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.exceptions.ObjectNotFoundException;
import com.marquezv.dev.apiTeste.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRespository;
	
	public User findById(Long id) {
		return userRespository.findById(id)
				.orElseThrow(
						() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
	
}

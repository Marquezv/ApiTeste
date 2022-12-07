package com.marquezv.dev.apiTeste.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.domain.dto.UserDTO;
import com.marquezv.dev.apiTeste.exceptions.DataIntegratyViolationException;
import com.marquezv.dev.apiTeste.exceptions.ObjectNotFoundException;
import com.marquezv.dev.apiTeste.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(
						() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User create(UserDTO userDTO) {
		findByEmail(userDTO);
		return repository.save(mapper.map(userDTO, User.class));
	}
	
	public User update(UserDTO userDTO) {
		findByEmail(userDTO);
		return repository.save(mapper.map(userDTO, User.class));
	}
	
	private void findByEmail(UserDTO userDTO) {
		Optional<User> user = repository.findByEmail(userDTO.getEmail());
		if(user.isPresent() && !user.get().getId().equals(userDTO.getId())) {
			throw new DataIntegratyViolationException("E-mail em utilizacao");
		}
	}
	
}

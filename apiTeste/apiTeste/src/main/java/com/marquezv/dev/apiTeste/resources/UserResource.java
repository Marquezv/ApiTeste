package com.marquezv.dev.apiTeste.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marquezv.dev.apiTeste.domain.dto.UserDTO;
import com.marquezv.dev.apiTeste.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		return ResponseEntity.ok().body(
				userService.findAll().stream()
					.map(user -> mapper.map(user, UserDTO.class))
					.collect(Collectors.toList())
				);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
		System.out.println("Aqui");
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userService.create(userDTO).getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}

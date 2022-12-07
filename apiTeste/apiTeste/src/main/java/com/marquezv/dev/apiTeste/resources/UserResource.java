package com.marquezv.dev.apiTeste.resources;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
	}
	
}

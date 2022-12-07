package com.marquezv.dev.apiTeste.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
}

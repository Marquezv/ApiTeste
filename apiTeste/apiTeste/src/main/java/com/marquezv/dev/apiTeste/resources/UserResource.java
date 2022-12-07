package com.marquezv.dev.apiTeste.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marquezv.dev.apiTeste.domain.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(new User((long) 1, "Vini", "vini@gamil.com", "123"));
	}
	
}

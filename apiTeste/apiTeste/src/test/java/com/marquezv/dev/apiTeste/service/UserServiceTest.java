package com.marquezv.dev.apiTeste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.marquezv.dev.apiTeste.domain.User;
import com.marquezv.dev.apiTeste.domain.dto.UserDTO;
import com.marquezv.dev.apiTeste.exceptions.ObjectNtFoundException;
import com.marquezv.dev.apiTeste.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	private static final String PASSWORD = "123";

	private static final String EMAIL = "vini@gmail.com";

	private static final String USERNAME = "Vini";

	private static final long ID = (long) 1;

	@InjectMocks // Classe a ser testada
	private UserService userService;
	
	@Mock // Classe auxiliar para o teste
	private UserRepository repository;
	
	@Mock // Classe auxiliar para o teste
	private ModelMapper mapper;
	
	private User user;
	private UserDTO userDTO;
	private Optional<User> optionalUser;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}
	
	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		Mockito.when(
				repository.findById(Mockito.anyLong()))
		.thenReturn(optionalUser);
		
		User res = userService.findById(ID);
		
		assertNotNull(res);
		assertEquals(User.class, res.getClass());
		assertEquals(ID, res.getId());
		assertEquals(USERNAME, res.getUsername());
		assertEquals(EMAIL, res.getEmail());
	}
	
	@Test
	void whenFindByIdThenReturnAnObjectNotFoundException() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenThrow(new ObjectNtFoundException("Objeto não encontrado"));
		
		try {
			userService.findById(ID);
		} catch (Exception err) {
			assertEquals(ObjectNtFoundException.class, err.getClass());
			assertEquals("Objeto não encontrado", err.getMessage());
		}
		
	}
	
	@Test
	void findAll() {
		
	}

	@Test
	void create() {

	}

	@Test
	void update() {
		
	}
	
	@Test
	void delete() {
		
	}
	
	private void startUser() {
		user = new User(ID, USERNAME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, USERNAME, EMAIL, PASSWORD);
		optionalUser = Optional.of(new User(ID, USERNAME, EMAIL, PASSWORD));
	}
}

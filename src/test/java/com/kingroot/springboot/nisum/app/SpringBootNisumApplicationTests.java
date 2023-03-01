package com.kingroot.springboot.nisum.app;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.SystemPropertyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestMethodOrder;

import com.kingroot.springboot.nisum.app.dto.PhoneDto;
import com.kingroot.springboot.nisum.app.dto.UserDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBootNisumApplicationTests {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Order(value = 1)
	void createUser() throws JsonProcessingException {
		System.out.println("******* createUser");
		UserDto user = new UserDto();
		List<PhoneDto> phones = new ArrayList<>();
		user.setName("testUnit");
		user.setEmail("test@test.com");
		user.setPassword("ASD");
		phones.add(new PhoneDto("3214569", "57", "58"));
		user.setPhones(phones);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>(this.mapper.writeValueAsString(user), headers);
		// Act
		ResponseEntity<String> createdUserDetailsEntity = testRestTemplate.postForEntity("/user/create-user", request,
				String.class);
		String jsonBody = createdUserDetailsEntity.getBody();
		JsonNode createUserResponseJson = new ObjectMapper().readTree(jsonBody);
		// Assert
		assertEquals(HttpStatus.CREATED, createdUserDetailsEntity.getStatusCode());
		assertFalse(createUserResponseJson.get("id").toString().trim().isEmpty(), "userId should not be empty");
	}

	@Test
	@Order(value = 2)
	void createUserUniqueEmail() throws JsonProcessingException {
		System.out.println("****** createUserUniqueEmail");
		UserDto user = new UserDto();
		List<PhoneDto> phones = new ArrayList<>();
		user.setName("testUnit");
		user.setEmail("test@test.com");
		user.setPassword("ASD");
		phones.add(new PhoneDto("3214569", "57", "58"));
		user.setPhones(phones);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>(this.mapper.writeValueAsString(user), headers);
		// Act
		ResponseEntity<String> createdUserDetailsEntity = testRestTemplate.postForEntity("/user/create-user", request,
				String.class);
		String jsonBody = createdUserDetailsEntity.getBody();
		JsonNode createUserResponseJson = new ObjectMapper().readTree(jsonBody);
		// Assert
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, createdUserDetailsEntity.getStatusCode());
		assertEquals(createUserResponseJson.get("mensaje").toString().replace("\"", ""),
				"El correo ya esta registrado");
	}

	@Test
	@Order(value = 3)
	void createUserValidateFields() throws JsonProcessingException {

		System.out.println("****** createUserValidateFields");
		UserDto user = new UserDto();

		user.setName(null);
		user.setEmail("test@test.com");
		user.setPassword("");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>(this.mapper.writeValueAsString(user), headers);
		// Act
		ResponseEntity<String> createdUserDetailsEntity = testRestTemplate.postForEntity("/user/create-user", request,
				String.class);

		// Assert
		assertEquals(HttpStatus.BAD_REQUEST, createdUserDetailsEntity.getStatusCode());

	}

}

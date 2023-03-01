package com.kingroot.springboot.nisum.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.kingroot.springboot.nisum.app.dto.UserDto;
import com.kingroot.springboot.nisum.app.exception.CreateUserException;
import com.kingroot.springboot.nisum.app.interfaces.IUser;
import com.kingroot.springboot.nisum.app.utils.MessageUtilReturn;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUser iUser;
	
	@ResponseBody
	@RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> createUser(@Valid @RequestBody(required = true) final UserDto user) throws CreateUserException {
		logger.info("/create-user init method createUser");
		try {			
			return new ResponseEntity<>(iUser.saveUsers(user), HttpStatus.CREATED); 
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("/create-user init method createUser " +e.getMessage());
			return new ResponseEntity<>(MessageUtilReturn.responseMessage("mensaje", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}

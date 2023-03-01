package com.kingroot.springboot.nisum.app.interfaces;

import org.springframework.stereotype.Service;

import com.kingroot.springboot.nisum.app.dto.UserDto;
import com.kingroot.springboot.nisum.app.exception.CreateUserException;
@Service
public interface IUser {

	public Object saveUsers(UserDto userDto) throws CreateUserException;	
}

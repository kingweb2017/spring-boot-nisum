package com.kingroot.springboot.nisum.app.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kingroot.springboot.nisum.app.config.jwt.TokenUtils;
import com.kingroot.springboot.nisum.app.dao.UserRepositoryDao;
import com.kingroot.springboot.nisum.app.dto.UserDto;
import com.kingroot.springboot.nisum.app.exception.CreateUserException;
import com.kingroot.springboot.nisum.app.interfaces.IUser;
import com.kingroot.springboot.nisum.app.model.Phone;
import com.kingroot.springboot.nisum.app.model.User;
import com.kingroot.springboot.nisum.app.utils.Constantes;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component
public class UserImplement implements IUser {
	
	private Logger logger = LoggerFactory.getLogger(UserImplement.class);
	@Autowired
	private UserRepositoryDao userRepositoryDao;
	@Autowired
	private Environment environment;
	
	

	@Override
	public Object saveUsers(UserDto userDto) throws CreateUserException  {
		
		logger.info("UserImplement method init saveUsers");
		// TODO Auto-generated method stub
		logger.info("userRepositoryDao.findByEmail(userDto.getEmail()) " + userDto.getEmail());
		Optional<User> user = userRepositoryDao.findByEmail(userDto.getEmail());
		logger.info("Value properties msgEmailExist: "+environment.getProperty("spring-boot-nisum.msgEmailExist"));
		logger.info("if(user.isPresent()) " + user.isPresent());
		if(user.isPresent())
			throw new CreateUserException(environment.getProperty("spring-boot-nisum.msgEmailExist"));
		
		User userModel = new User();
		userModel.setName(userDto.getName());
		userModel.setEmail(userDto.getEmail());
		userModel.setPassword(userDto.getPassword());
		userModel.setCreated(new Date());
		userModel.setIsActive(true);
		userModel.setLastLogin(new Date());
		userModel.setModified(new Date());
		List<Phone> listPhone = new ArrayList<Phone>();
		userDto.getPhones().forEach( p-> {
			listPhone.add(new Phone(0, p.getNumber(), p.getCitycode(), p.getContrycode(),userModel));
		} );
		userModel.setPhones(listPhone);
		userRepositoryDao.save(userModel);
		UserDto userDtoRespond = new UserDto();
		userDtoRespond.setId(userModel.getId());
		userDtoRespond.setEmail(userModel.getEmail());
		userDtoRespond.setCreated(userModel.getCreated());
		userDtoRespond.setModified(userModel.getModified());
		userDtoRespond.setIsActive(userModel.getIsActive());
		userDtoRespond.setLastLogin(userModel.getLastLogin());
		//userDtoRespond.setToken(TokenUtils.createToken(userModel.getEmail(), userModel.getName()));
		
	
		return userDtoRespond;
	}
	

	
	
}

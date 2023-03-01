package com.kingroot.springboot.nisum.app.dto;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UserDto {
	
	private long id;
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String name;
	@NotEmpty(message = "El correo no puede ser vacio")	
	@Pattern(regexp="^[^@]+@[^@]+\\.[a-zA-Z]{2,}$",message="format incorrect")  
	private String email;	
	@NotEmpty(message = "La contraseña no puede ser vacio")
    @Pattern(regexp="[A-Za-z\\d$@$!%*?&]{8,15}")  
	private String password;
	@NotEmpty(message = "Debe tener al menos un numero de telefono")
	private List<PhoneDto> phones;
	
	private String token;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private Boolean isActive;
	
	public UserDto() {
	}

	public UserDto(String name, String email, String password, List<PhoneDto> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}

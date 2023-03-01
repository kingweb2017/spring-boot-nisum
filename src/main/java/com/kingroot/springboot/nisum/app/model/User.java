package com.kingroot.springboot.nisum.app.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name="user")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private long id;
	@Column(name="name", nullable = false)
	private String name;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="created")
	private Date created;
	@Column(name="modified")
	private Date modified;
	@Column(name="last_login")
	private Date lastLogin;
	@Column(name="is_active")
	private Boolean isActive;	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")	
	private List<Phone> phones;
	
	public User() {
		
	}



	public User(long id, String name, String email, String password, Date created, Date modified, Date lastLogin,
			Boolean isActive, @NotNull List<Phone> phones) {	
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
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

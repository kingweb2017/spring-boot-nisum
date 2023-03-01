package com.kingroot.springboot.nisum.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name="phone")
@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="number", nullable = false)
	private String number;
	@Column(name="city_code", nullable = false)
	private String cityCode;
	@Column(name="contry_code", nullable = false)
	private String contryCode;
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	@ManyToOne(optional = false)
	private User idUser;
	
	public Phone() {
		
	}

	public Phone(long id, String number, String cityCode, String contryCode, User user) {
		super();
		this.id = id;
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
		this.idUser = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	public User getUser() {
		return idUser;
	}

	public void setUser(User user) {
		this.idUser = user;
	}

}

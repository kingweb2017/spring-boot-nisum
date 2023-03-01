package com.kingroot.springboot.nisum.app.dto;

import jakarta.validation.constraints.NotEmpty;

public class PhoneDto {
	@NotEmpty(message = "El número no puede ser vacio")
	private String number;
	@NotEmpty(message = "El codigo no puede ser vacio")
    private String cityCode;
	@NotEmpty(message = "El número no puede ser vacio")
    private String contryCode;
    
    
	public PhoneDto() {				
	}
    
	public PhoneDto(String number, String cityCode, String contryCode) {		
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return cityCode;
	}
	public void setCitycode(String citycode) {
		this.cityCode = citycode;
	}
	public String getContrycode() {
		return contryCode;
	}
	public void setContrycode(String contrycode) {
		this.contryCode = contrycode;
	}
    
    
	
}

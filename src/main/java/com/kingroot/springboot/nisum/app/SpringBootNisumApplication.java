package com.kingroot.springboot.nisum.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;





@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@SpringBootApplication
public class SpringBootNisumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNisumApplication.class, args);
	}
	


}

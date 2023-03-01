package com.kingroot.springboot.nisum.app.config.jwt;



//@Configuration
public class WebSecurityConfig  {
/*
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		
		
		return http
				.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/user/create-user")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.build();
	}
	
	@Bean
	UserDetailsService userDatailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user")
				.password(passwordEncoder().encode("passUser"))
				.roles()
				.build());
		return manager;
	}
	
	@Bean
	AuthenticationManager autManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDatailService())
				.passwordEncoder(passwordEncoder())
				.and().build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	*/
}

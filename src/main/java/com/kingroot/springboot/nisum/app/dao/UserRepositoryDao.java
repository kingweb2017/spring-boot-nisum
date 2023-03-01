package com.kingroot.springboot.nisum.app.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kingroot.springboot.nisum.app.model.User;


public interface UserRepositoryDao extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
}

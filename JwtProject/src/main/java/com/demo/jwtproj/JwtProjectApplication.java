package com.demo.jwtproj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.jwtproj.entity.AppUser;
import com.demo.jwtproj.repository.UserRepository;

@SpringBootApplication
public class JwtProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(UserRepository repo,
	                         PasswordEncoder encoder) {

	    return args -> {

	        AppUser user = new AppUser();

	        user.setUsername("admin");

	        user.setPassword(
	                encoder.encode("admin123"));

	        user.setRole("ADMIN");

	        repo.save(user);
	    };
	}

}

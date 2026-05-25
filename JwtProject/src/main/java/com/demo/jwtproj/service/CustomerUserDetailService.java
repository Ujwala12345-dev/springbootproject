package com.demo.jwtproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.jwtproj.entity.AppUser;
import com.demo.jwtproj.repository.UserRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	@Autowired
    private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		
        
		AppUser user = repo.findByUsername(username)
                .orElseThrow(() ->
                     new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
		
	}

}

package com.nextgenbooks.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nextgenbooks.admin.user.UserRepo;
import com.nextgenbooks.common.entity.User;

public class BookstoreUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.getUserByEmail(email);
		if (user != null) {
			return new BookstoreUserDetails(user);
		}
		
		throw new UsernameNotFoundException(email);
	}

}

package com.nextgenbooks.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nextgenbooks.common.entity.User;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll() {
		return (List<User>) repo.findAll();	
	}
	
	public User get(Integer id) throws NoSuchElementException {
		try {
			return repo.findById(id).get();
		} catch (NoSuchElementException e) { return null;}
	}
	
	public void delete(Integer id) throws NoSuchElementException {
		Long count = repo.countById(id);
		if (count ==  null || count == 0) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}
	
	public void updateUserEnable(Integer id, boolean enabled) {
		repo.updateEnable(id, enabled);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
	public void save(User user) {
		encodePassword(user);
		repo.save(user);
	}

}

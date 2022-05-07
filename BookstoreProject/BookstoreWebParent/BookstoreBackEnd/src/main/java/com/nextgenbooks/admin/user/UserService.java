package com.nextgenbooks.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nextgenbooks.common.entity.Role;
import com.nextgenbooks.common.entity.User;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepo repo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll() {
		return (List<User>) repo.findAll();	
	}
	
	public List<Role> listRoles() {
		return (List<Role>) roleRepo.findAll();	
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
		
	//check whether it is an existing user or a new user
	public User save(User user) {
		boolean update = (user.getId()!=null);
		if (update) {
			User existingUser = repo.findById(user.getId()).get();
			if (user.getPassword().isEmpty()) {
				user.setPassword(existingUser.getPassword());
			} else {
				encodePassword(user);
			}
		} else {
			encodePassword(user);
		}

		return repo.save(user);
	}
	
	public User updateAccount(User user) {
		User existingUser =  repo.findById(user.getId()).get();
		String pw = user.getPassword();
		if(!pw.isEmpty()) {
			existingUser.setPassword(pw);
			encodePassword(existingUser);
		}
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		
		return repo.save(existingUser);
	}
	
	public User getByEmail(String email) {
		return repo.getUserByEmail(email);
	}
	
	//check if a user with the same email is already in the system
	public boolean isEmailUnique(Integer id, String email) {
		User user = repo.getUserByEmail(email);
		if (user == null)  {
			return true;
		}

		boolean isNew = (id == null);
		//if we are creating a new user but we see email is already in system, return false
		if (isNew) {
			if(user !=null) return false;			
		} else {
			if (user.getId() !=id) {
				return false;
			}
		} 
	
		return true;
	}

}

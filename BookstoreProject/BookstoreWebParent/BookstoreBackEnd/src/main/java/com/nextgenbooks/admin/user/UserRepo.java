package com.nextgenbooks.admin.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	//method provided by spring data jpa
	public Long countById(Integer id);
	
	//use second param of method as status and first param as id
	@Query("UPDATE User u SET u.enabled =?2 WHERE u.id = ?1")
	@Modifying
	public void updateEnable(Integer id, boolean enabled) ;

	//get user by email
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);
		

}

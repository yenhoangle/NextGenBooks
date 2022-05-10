package com.nextgenbooks.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Role;
import com.nextgenbooks.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserRepoTests {
	@Autowired
	private UserRepo repo;
	
	//for getting roles in the db
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testCreate() {
		//create yen
		Role adminRole = entityManager.find(Role.class, 1);
		User yen = new User("yenhgle@gmail.com", "$2a$10$T4s30H30KyvLhd4cVt3lQuMcdejcVrAuc2VFnYoBbtLUNnuggwf9q", "Yen", "Le");
		yen.addRole(adminRole);
		//create john
		Role managerRole = entityManager.find(Role.class, 2);
		User john = new User("jsmith@gmail.com", "$2a$10$T4s30H30KyvLhd4cVt3lQuMcdejcVrAuc2VFnYoBbtLUNnuggwf9q", "John", "Smith");
		john.addRole(managerRole);
		User savedUser1 = repo.save(yen);
		User savedUser2 = repo.save(john);
		assertThat(savedUser1.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testEnabled() {
		User yen = repo.findById(1).get();
		User john = repo.findById(2).get();
		yen.setEnabled(true);
		john.setEnabled(true);
	}
	
	@Test
	public void testCountById() {
		Integer id = 1;
		Long count = repo.countById(id);
		assertThat(count).isNotNull().isGreaterThan(0);
	}
	
	@Test
	public void testDisable() {
		Integer id = 2;
		repo.updateEnable(id, false);
	}
	
	@Test
	public void testEnable() {
		Integer id = 2;
		repo.updateEnable(id, true);
	}
	

}

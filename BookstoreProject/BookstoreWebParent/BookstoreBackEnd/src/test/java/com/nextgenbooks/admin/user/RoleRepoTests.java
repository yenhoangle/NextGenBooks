package com.nextgenbooks.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Role;
import com.nextgenbooks.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepoTests {

	@Autowired
	private RoleRepo repo;
	
	@Test
	public void testAdmin() {
		Role admin = new Role("Admin", "Full authorization");
		Role saved = repo.save(admin);
		assertThat(saved.getId()).isGreaterThan(0);
	}
	
	@Test void testManager() {
		Role manager = new Role("Manager", "Authorization for products and orders");
		Role saved = repo.save(manager);
		assertThat(saved.getId()).isGreaterThan(0);
	}
	
}

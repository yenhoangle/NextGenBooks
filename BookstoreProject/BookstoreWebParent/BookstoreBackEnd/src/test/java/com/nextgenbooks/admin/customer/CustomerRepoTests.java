package com.nextgenbooks.admin.customer;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Customer;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepoTests {
	
	@Autowired private CustomerRepo repo;
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();

		customer.setFirstName("Tri");
		customer.setLastName("Tran");
		customer.setPassword("$2a$10$T4s30H30KyvLhd4cVt3lQuMcdejcVrAuc2VFnYoBbtLUNnuggwf9q");
		customer.setEmail("ttran@gmail.com");
		customer.setAddressLine1("123 Jump Street");
		customer.setAddressLine2("Apt 456");
		customer.setCity("New York");
		customer.setState("New York");
		customer.setCountry("United States");
		customer.setPhoneNum("408-444-4444");

		Customer saved = repo.save(customer);

		assertThat(saved.getId()).isGreaterThan(0);
	}
	
	@Test void testCreateRest() {
		Customer two = new Customer();
		two.setFirstName("Samantha");
		two.setLastName("Vo");
		two.setPassword("$2a$10$T4s30H30KyvLhd4cVt3lQuMcdejcVrAuc2VFnYoBbtLUNnuggwf9q");
		two.setEmail("samvo@gmail.com");
		two.setAddressLine1("111 Circle Lane");
		two.setAddressLine2("Unit 4");
		two.setCity("Sacramento");
		two.setState("California");
		two.setCountry("United States");
		two.setPhoneNum("435-544-4588");
		
		Customer three = new Customer();
		three.setFirstName("Peter");
		three.setLastName("McDowell");
		three.setPassword("$2a$10$T4s30H30KyvLhd4cVt3lQuMcdejcVrAuc2VFnYoBbtLUNnuggwf9q");
		three.setEmail("petmc@gmail.com");
		three.setAddressLine1("349 Montana Way");
		three.setAddressLine2("Apt 6");
		three.setCity("Salt Lake City");
		three.setState("Utah");
		three.setCountry("United States");
		three.setPhoneNum("635-222-6523");
		
		repo.save(two);
		repo.save(three);
	}
	
	@Test 
	void getCustomer() {
		Customer customer = repo.findById(1).get();
		System.out.println(customer.getFullName());
	}
}

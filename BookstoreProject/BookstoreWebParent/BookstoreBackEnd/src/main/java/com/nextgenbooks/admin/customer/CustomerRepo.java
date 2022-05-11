package com.nextgenbooks.admin.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
	@Query("UPDATE Customer c SET c.enabled = ?2 WHERE c.id = ?1")
	@Modifying
	public void updateEnable(Integer id, boolean enabled);

	public Long countById(Integer id);

}

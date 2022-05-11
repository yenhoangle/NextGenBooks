package com.nextgenbooks.admin.customer;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgenbooks.common.entity.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepo repo;
	
	public List<Customer> listAll() {
		return (List<Customer>)repo.findAll();
	}
	
	
	public void updateCustomerEnable(Integer id, boolean enabled) {
		repo.updateEnable(id, enabled);
	}
	
	public void delete(Integer id) throws NoSuchElementException {
		Long count = repo.countById(id);
		if (count ==  null || count == 0) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}
}

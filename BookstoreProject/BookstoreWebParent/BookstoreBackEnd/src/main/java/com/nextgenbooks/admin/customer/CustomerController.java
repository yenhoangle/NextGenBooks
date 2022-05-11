package com.nextgenbooks.admin.customer;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextgenbooks.common.entity.Customer;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public String listAll(Model model) {
		List<Customer> listCustomers = service.listAll();
		model.addAttribute("listCustomers", listCustomers);
		return "customers";
	}
	
	@GetMapping("/customers/{id}/enabled/{status}")
	public String updateCustomerEnabled(@PathVariable(name="id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirAtt) {
		service.updateCustomerEnable(id, enabled);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/customers";
	}
}

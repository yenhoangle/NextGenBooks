package com.nextgenbooks.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextgenbooks.common.entity.User;



@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}/enabled/{status}")
	public String updateUserEnabled(@PathVariable(name="id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirAtt) {
		service.updateUserEnable(id, enabled);
		return "redirect:/users";
	}
}

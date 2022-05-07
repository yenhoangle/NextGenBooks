package com.nextgenbooks.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextgenbooks.common.entity.Role;
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
	
	@GetMapping("/users/new") 
	public String newUser(Model model) {
		List<Role> listRoles = service.listRoles();
		User user = new User();
		user.setEnabled(true);
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("pgTitle", "New User");
		return "user_form";
	}
	

	@PostMapping("/users/save")
	public String saveUser(User user) {
		service.save(user);
		return "redirect:/users";
	} 
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			User user = service.get(id);
			List<Role> listRoles = service.listRoles();
			model.addAttribute("user", user);
			model.addAttribute("pgTitle", "Editing User");
			model.addAttribute("listRoles", listRoles);
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

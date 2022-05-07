package com.nextgenbooks.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nextgenbooks.admin.security.BookstoreUserDetails;
import com.nextgenbooks.common.entity.User;

@Controller
public class AccountController {
	@Autowired
	private UserService service;
	@GetMapping("/account")
	public String viewDetails(@AuthenticationPrincipal BookstoreUserDetails loggedUser, Model model) {
		String email = loggedUser.getUsername();
		User user = service.getByEmail(email);
		model.addAttribute("user", user);
		return "account_form";
	}
	
	@PostMapping("/account/update")
	public String saveDetails(User user) {
		service.save(user);
		return "redirect:/account";
	} 

}

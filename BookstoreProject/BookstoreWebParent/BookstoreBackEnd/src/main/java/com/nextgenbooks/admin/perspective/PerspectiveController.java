package com.nextgenbooks.admin.perspective;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextgenbooks.common.entity.Genre;
import com.nextgenbooks.common.entity.Perspective;

@Controller
public class PerspectiveController {
	@Autowired
	private PerspectiveService service;
	
	@GetMapping("/perspectives")
	public String listAll(Model model) {
		List<Perspective> listPerspectives = service.listAll();
		model.addAttribute("listPerspectives", listPerspectives);
		return "perspectives";
	}
	
	@GetMapping("/perspectives/new")
	public String newPerspective(Model model) {
		List<Genre> listGenres = service.listGenres();
		model.addAttribute("listGenres", listGenres);
		model.addAttribute("perspective", new Perspective());
		model.addAttribute("pgTitle", "Create New Perspective");
		return "perspective_form";
	}
	
	@PostMapping("/perspectives/save")
	public String savePerspective(Perspective perspective) {
		service.save(perspective);
		return "redirect:/perspectives";
	}
		
	@GetMapping("/perspectives/delete/{id}")
	public String deletePerspective(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/perspectives";
	}
}

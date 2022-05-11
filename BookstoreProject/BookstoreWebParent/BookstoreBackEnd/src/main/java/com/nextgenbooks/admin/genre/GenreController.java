package com.nextgenbooks.admin.genre;

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


@Controller
public class GenreController {
	@Autowired
	private GenreService service;
	
	@GetMapping("/genres")
	public String listAll(Model model) {
		List<Genre> listGenres = service.listAll();
		model.addAttribute("listGenres",listGenres);
		return "genres";
	}
	
	@GetMapping("/genres/new")
	public String newGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "genre_form";
	}
	
	@PostMapping("/genres/save")
	public String saveGenre(Genre genre) {
		service.save(genre);
		return "redirect:/genres";
	}
	
	@GetMapping("/genres/{id}/enabled/{status}")
	public String updateUserEnabled(@PathVariable(name="id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirAtt) {
		service.updateGenreEnable(id, enabled);
		return "redirect:/genres";
	}
	
	@GetMapping("/genres/delete/{id}")
	public String deleteGenre(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/genres";
	}
}

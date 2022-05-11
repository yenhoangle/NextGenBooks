package com.nextgenbooks.admin.book;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.nextgenbooks.common.entity.Book;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public String listAll(Model model) {
		List<Book> listBooks = service.listAll();
		model.addAttribute("listBooks", listBooks);
		return "books";
	}
	
	@GetMapping("/books/new")
	public String newBooks(Model model) {
		model.addAttribute("book", new Book());
		return "book_form";
	}
	
	@PostMapping("/books/save")
	public String saveGenre(Book book) {
		service.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/enabled/{status}")
	public String updateBookEnabled(@PathVariable(name="id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirAtt) {
		service.updateBookEnable(id, enabled);
		return "redirect:/books";
	}
	
	@GetMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirAtt) {
		try {
			service.delete(id);
		} catch (NoSuchElementException e) {
			
		}
		return "redirect:/books";
	}
}

package com.nextgenbooks.admin.book;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nextgenbooks.common.entity.Book;


@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public List<Book> listAll() {
		return (List<Book>)repo.findAll();
	}
	
	public Book save(Book book) {
		return repo.save(book);
		
	}
	
	public void updateBookEnable(Integer id, boolean enabled) {
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

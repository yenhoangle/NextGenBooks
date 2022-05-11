package com.nextgenbooks.admin.genre;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nextgenbooks.common.entity.Genre;

@Service
@Transactional
public class GenreService {
	@Autowired
	private GenreRepo repo;
	
	public List<Genre> listAll() {
		return (List<Genre>)repo.findAll();
	}
	
	public Genre save(Genre genre) {
		return repo.save(genre);
		
	}
	
	public void updateGenreEnable(Integer id, boolean enabled) {
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

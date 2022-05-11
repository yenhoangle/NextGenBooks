package com.nextgenbooks.admin.perspective;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgenbooks.admin.genre.GenreRepo;
import com.nextgenbooks.common.entity.Genre;
import com.nextgenbooks.common.entity.Perspective;

@Service
@Transactional
public class PerspectiveService {
	@Autowired
	private PerspectiveRepo repo;
	
	@Autowired
	private GenreRepo genRepo;
	
	public List<Perspective> listAll() {
		return (List<Perspective>)repo.findAll();
	}
	
	public List<Genre> listGenres() {
		return (List<Genre>) genRepo.findAll();
		
	}
		
	public Perspective save(Perspective perspective) {
		return repo.save(perspective);
		
	}
	
	public void delete(Integer id) throws NoSuchElementException {
		Long count = repo.countById(id);
		if (count ==  null || count == 0) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}
	
}

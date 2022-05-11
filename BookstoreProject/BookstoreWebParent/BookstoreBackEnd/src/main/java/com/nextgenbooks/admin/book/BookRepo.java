package com.nextgenbooks.admin.book;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nextgenbooks.common.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

	//method provided by spring data jpa
	public Long countById(Integer id);
	
	//use second param of method as status and first param as id
	@Query("UPDATE Book b SET b.enabled =?2 WHERE b.id = ?1")
	@Modifying
	public void updateEnable(Integer id, boolean enabled);

}

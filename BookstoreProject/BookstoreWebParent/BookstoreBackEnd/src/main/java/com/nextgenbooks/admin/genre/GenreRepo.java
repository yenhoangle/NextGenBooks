package com.nextgenbooks.admin.genre;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.Genre;

@Repository
//use second param of method as status and first param as id
public interface GenreRepo extends CrudRepository<Genre, Integer>{
	@Query("UPDATE Genre g SET g.enabled = ?2 WHERE g.id = ?1")
	@Modifying
	public void updateEnable(Integer id, boolean enabled);

	public Long countById(Integer id);

}

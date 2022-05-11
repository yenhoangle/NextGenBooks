package com.nextgenbooks.admin.perspective;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.Perspective;

@Repository
public interface PerspectiveRepo extends CrudRepository<Perspective, Integer> {
	public Long countById(Integer id);
}

package com.nextgenbooks.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}

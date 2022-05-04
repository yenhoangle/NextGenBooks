package com.nextgenbooks.admin.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgenbooks.common.entity.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer>{

}

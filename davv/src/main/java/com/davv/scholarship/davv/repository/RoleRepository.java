package com.davv.scholarship.davv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davv.scholarship.davv.entity.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findRoleByName(String role);

}

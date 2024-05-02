package com.davv.scholarship.davv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davv.scholarship.davv.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUserName(String userName);

}

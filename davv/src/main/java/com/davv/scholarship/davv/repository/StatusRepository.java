package com.davv.scholarship.davv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davv.scholarship.davv.entity.Status;
@Repository
public interface StatusRepository extends CrudRepository<Status, String> {

}

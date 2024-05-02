package com.davv.scholarship.davv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davv.scholarship.davv.entity.PersonalInfo;
@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, String> {

}

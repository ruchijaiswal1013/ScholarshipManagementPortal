package com.davv.scholarship.davv.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davv.scholarship.davv.entity.PersonalInfo;
import com.davv.scholarship.davv.repository.PersonalInfoRepository;

@Service
public class PersonalInfoService {

	@Autowired
	public PersonalInfoRepository personalInfoRepository;
	
	public void saveInfo(@Valid PersonalInfo theInfo) {
		personalInfoRepository.save(theInfo);
	}

	public Optional<PersonalInfo> getInfo(String name) {
		// TODO Auto-generated method stub
		return personalInfoRepository.findById(name);
	}
	
	public Iterable<PersonalInfo> getAll() {
		// TODO Auto-generated method stub
		return personalInfoRepository.findAll();
	}

}

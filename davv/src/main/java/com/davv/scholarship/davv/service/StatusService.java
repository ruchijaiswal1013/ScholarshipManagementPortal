package com.davv.scholarship.davv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davv.scholarship.davv.entity.Status;
import com.davv.scholarship.davv.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	public StatusRepository statusRepository;
	
	public void saveStatus(Status info) {
		// TODO Auto-generated method stub
		statusRepository.save(info);
	}

	public Optional<Status> getStatus(String name) {
		// TODO Auto-generated method stub
		return statusRepository.findById(name);
	}

	public Iterable<Status> getAll() {
		
		return statusRepository.findAll();
	}

}

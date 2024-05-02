package com.davv.scholarship.davv.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.davv.scholarship.davv.entity.User;
import com.davv.scholarship.davv.model.CrmUser;


public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
package com.davv.scholarship.davv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davv.scholarship.davv.entity.EmailDetails;
import com.davv.scholarship.davv.entity.PersonalInfo;
import com.davv.scholarship.davv.entity.Status;
import com.davv.scholarship.davv.service.EmailService;
import com.davv.scholarship.davv.service.PersonalInfoService;
import com.davv.scholarship.davv.service.StatusService;

@Controller
@RequestMapping(value="/systems")
public class AdminController {

	//need to inject personal serviceInfo and statusService
	@Autowired
	private PersonalInfoService personalInfoService; 
	
	@Autowired
	private EmailService emailService;

	
	@Autowired
	private StatusService statusService;

	@GetMapping(value="/")
	public String goSystem(Model themodel) {
		Iterable<Status> theInfo=statusService.getAll();
		themodel.addAttribute("pInfo", theInfo);
		return "system";
	}
	
	
	@GetMapping(value="/studentApprove/{userName:.+}")
	public String ShowPersonalInfo(@PathVariable String userName,Model themodel) {
		System.out.println(userName);
		// get the personal info from data base
		PersonalInfo theInfo=personalInfoService.getInfo(userName).get();
		
		//create statsu object and add to model
		Status status=new Status();
		themodel.addAttribute("status", status);
		themodel.addAttribute("pInfo", theInfo);
		return "student-approve";
	}

	
	@PostMapping(value="/processApprove/{userName:.+}")
	public String ShowPersonalInfo( @PathVariable String userName,@ModelAttribute("status") Status status, 
			Model theModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String userName = auth.getName();
		status.setUserName(userName);
		// Save status
		statusService.saveStatus(status);
		  //Email
        String message="";
        if(status.getStatus().equalsIgnoreCase("Approved")) {
        	message="Hi Student, \n Congratulations! You are eligible for scholarship \n Your application status is : "+status.getStatus();
        }else {
        	message="Hi Student, \n  You are not eligible for scholarship \n Your application status is : "+status.getStatus();
        }
        EmailDetails details= new EmailDetails();
        details.setRecipient(userName);
        details.setSubject("Application Status ");
        details.setMsgBody(message);
        
        emailService.sendSimpleMail(details);
        
     
		return "redirect:/systems/";
	}
}

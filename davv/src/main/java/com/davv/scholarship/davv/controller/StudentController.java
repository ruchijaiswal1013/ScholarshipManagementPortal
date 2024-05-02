package com.davv.scholarship.davv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davv.scholarship.davv.entity.PersonalInfo;
import com.davv.scholarship.davv.entity.Status;
import com.davv.scholarship.davv.service.PersonalInfoService;
import com.davv.scholarship.davv.service.StatusService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Need to inject our personalInfoService
	@Autowired
	private PersonalInfoService personalInfoService;

	// Need to inject our StatusService
	@Autowired
	private StatusService statusService;

	@GetMapping(value = "/personalInfo")
	public String ShowPersonalInfo(Model themodel) {

		// Create personalInfo object
		PersonalInfo pInfo = new PersonalInfo();

		// add personalInfo to model
		themodel.addAttribute("pInfo", pInfo);

		// Return to personalInfo.jsp page
		return "personal-info";
	}

	@PostMapping("/processInfoForm")
	public String processPersonalInfo(@Valid @ModelAttribute("pInfo") PersonalInfo theInfo,
			BindingResult theBindingResult, Model theModel) {

		// for validation check
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("registrationError", "All fields are required and must filled in given formate.");
			return "personal-info";
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String userName = auth.getName();
			// set user name
			theInfo.setUserName(userName);
			System.out.println(userName);
			// save theInfo object in our database
			System.out.println("****Error block Start");
			System.out.println("****Error block Start"+ theInfo.getsName());
			personalInfoService.saveInfo(theInfo);
			System.out.println("****Error block End");
			Status Info = new Status(theInfo.getUserName(), "panding");
			statusService.saveStatus(Info);
			theModel.addAttribute("pInfo", theInfo);

			// return to home.jsp page
			return "user-home";
		}
	}

	@GetMapping("/viewInfoForm")
	public String viewPersonalInfo(Authentication authentication, Model theModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		// get the Persnal Information using primay key
		PersonalInfo theInfo = personalInfoService.getInfo(userName).get();
		System.out.println(userName);
		// add PersonalInfo object to model
		theModel.addAttribute("pInfo", theInfo);

		return "view-info";
	}

	@GetMapping("/viewStatus")
	public String viewStatus(Authentication authentication, Model theModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		// create Status object and get the status form database
		Status theInfo = statusService.getStatus(userName).get();

		// add status object to model
		theModel.addAttribute("pInfo", theInfo);
		return "view-status";
	}

}

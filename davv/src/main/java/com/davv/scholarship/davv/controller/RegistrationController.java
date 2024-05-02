package com.davv.scholarship.davv.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davv.scholarship.davv.entity.EmailDetails;
import com.davv.scholarship.davv.entity.User;
import com.davv.scholarship.davv.model.CrmUser;
import com.davv.scholarship.davv.service.EmailService;
import com.davv.scholarship.davv.service.RoleService;
import com.davv.scholarship.davv.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private RoleService roleService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/")
	public String showMyLoginPage(Model theModel) {

		theModel.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName +"   ");
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "registration-form";
	        }

		// check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
        	theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
        	return "registration-form";
        }
         
		String message = null;
		try {
	        // create user account

			userService.save(theCrmUser);
			message = "Customer Register with id " + theCrmUser.getUserName();
		} catch (Exception e) {
			message = "Customer not saved due to " + e.getMessage();
		}
		theModel.addAttribute("message", message);
		theModel.addAttribute("customer", new User());
		
        logger.info("Successfully created user: " + userName);
        
        
        //userService.save(theCrmUser);
       //Email
        String message1="Congratulations ....! \n "+ theCrmUser.getFirstName() +" "
        +theCrmUser.getLastName() +" you have successfully registerd to DAVV SCHOLARSHIP PORTAL ";
        EmailDetails details= new EmailDetails();
        details.setRecipient(theCrmUser.getEmail());
        details.setSubject("Registration confirmation ");
        details.setMsgBody(message1);
        String status
        = emailService.sendSimpleMail(details);
        
        System.out.println(status);
        		logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
package com.davv.scholarship.davv.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/Login")
	public String showMyLoginPage() {
		
		return "login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
	@PostMapping("/logout")
	public String showSignoutPage() {
		System.out.println("Logout success");
		return "login";
		
	}
	
	//Mapping for application main page
	@GetMapping("/DavvHome")
	public String showcogniHome() {
		
		return "davv-home";
		
	}
	

	@GetMapping("/")
	public String showHome() {
		
		return "user-home";
	}
}



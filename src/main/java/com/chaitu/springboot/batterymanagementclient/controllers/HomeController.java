package com.chaitu.springboot.batterymanagementclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/batterymanagementhomepage")
	public String select() {
		
		return "batterymanagementhomepage";
	}
	
	@GetMapping("/manufacturehomepage")
	public String manufacture() {
		
		
		return "manufacturehomepage";
	}
	
	@GetMapping("/batterydatahomepage")
	public String Batterydata() {
		
		
		return "batterydatahomepage";
	}

}

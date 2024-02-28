package com.chaitu.springboot.batterymanagementclient.controllers;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.chaitu.springboot.batterymanagementclient.model.BatteryData;
import com.chaitu.springboot.batterymanagementclient.model.BatteryManufacture;

@Controller
public class BatteryManufactureController {
	
	RestTemplate template=new RestTemplate();
	
	@GetMapping("/manufacturebatteryentry")
	public String batteryEntry() {
		
		
		return "manufacturebatteryentry";
		
	}
	
	@PostMapping("/savebatteryentry")
	public String saveBattery(@ModelAttribute("batterymanufacture") BatteryManufacture batteryManufacture,Model model) {
		
		BatteryManufacture data=template.postForObject("http://localhost:8081/batteryapi/batterymanufacture/", batteryManufacture, BatteryManufacture.class);
		
		if(data ==null)return "batterydatawarning";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		 
    	
        data.setFormatteddatetime(data.getManufacture_datetime().format(formatter));
        
        model.addAttribute("data",data);
		return "manufacturebatteryview";
	}
	
	@GetMapping("/getmanufacturebatterydata")
	public String getAll(Model model) {
		
		
		
		
		BatteryManufacture[] batterydata=template.getForObject("http://localhost:8081/batteryapi/batterymanufacture/", BatteryManufacture[].class);
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		    for (BatteryManufacture data : batterydata) {
		    	if(data.getManufacture_datetime()!=null)
		        data.setFormatteddatetime(data.getManufacture_datetime().format(formatter));
		    }
		//System.out.print(batterydata[0]);
		model.addAttribute("batterydata",batterydata);
		
		
		
		
		
		
		
		
		return "manufacturebatterydata";
	}
}

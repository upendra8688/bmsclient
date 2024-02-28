package com.chaitu.springboot.batterymanagementclient.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.chaitu.springboot.batterymanagementclient.model.BatteryData;
import com.chaitu.springboot.batterymanagementclient.model.ConstraintDateTime;
import com.chaitu.springboot.batterymanagementclient.model.DateTimedata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class BatteryDataController {
	
	RestTemplate template=new RestTemplate();
	
	
	
	@GetMapping("/batterydatadisplay")
	public String getAllDetails(Model model) {
		String viewname="batterydatadisplay";
		
		
		BatteryData[] batterydata=template.getForObject("http://localhost:8081/batteryapi/batterydata/", BatteryData[].class);
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");//hh converts from 24format to 12hr format and a represents am or pm
		    for (BatteryData data : batterydata) {
		    	if(data.getDatetime()!=null)
		        data.setFormateddatetime(data.getDatetime().format(formatter));
		    }
		//System.out.print(batterydata[0]);
		model.addAttribute("batterydata",batterydata);
		
		
		return viewname;
	}
	
	
	@GetMapping("/batterydatacreate")
	public String begin() {
		
		return "batterydatacreate";
	}
	
	
	@PostMapping("/batterydataentry")
	public String enterBatteryDetails(@ModelAttribute("batteryData") BatteryData batterydata, Model model) {
		
		String viewname="batteryentryview";
		
		/*BatteryData batteryentry =new BatteryData();
		batteryentry.setBatteryid(1);
		batteryentry.setCurrent(1.2);
		
		LocalDateTime dateTime = LocalDateTime.of(2023, 10, 15, 15, 30); // (year, month, day, hour, minute)
		
		batteryentry.setDatetime(dateTime);
		
		batteryentry.setTemperature(20.3f);
		
		batteryentry.setVoltage(2.5);*/
		BatteryData batterydetails=template.postForObject("http://localhost:8081/batteryapi/batterydata/",batterydata, BatteryData.class);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
	 
	    if(batterydetails== null)return "batterydatawarning";	
		
	        batterydetails.setFormateddatetime(batterydetails.getDatetime().format(formatter));
	    
		model.addAttribute("batterydetails",batterydetails);
		return viewname;
	}
	
	@GetMapping("/batteryuserdemandentry")
	public String userDemandEntry() {
		
		
		return "batteryuserdemandentry";
	}
	
	
	@GetMapping("/batteryuserdemandprocess")
	public String userDemand(@RequestParam("batteryid") int batteryid,@RequestParam("variable") String variable, Model model) throws JsonMappingException, JsonProcessingException {
		String viewname="batteryuserdemandview";
		
		String batterydetails=template.getForObject("http://localhost:8081/batteryapi/batterydata/"+batteryid+"/"+variable,String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println(batteryid+variable);
		System.out.println(batterydetails);
		
		Map<String,Object>[] data=null;
		
		try {
			  data=objectMapper.readValue(batterydetails,new TypeReference<Map<String, Object>[]>() {});//we can use Map[].class but it gives warning
			  System.out.println("Hii");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(data.length);
		
		
		 String[] keys=null;
		try {
			keys = data[0].keySet().toArray(new String[0]);
			 
			 if (data[0].containsKey("datetime")) {
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
				    
				    for (Map<String, Object> d : data) {
				        if (d.get("datetime") != null) {
				        	
				        	String datetime=(String)d.get("datetime");
				        	
				        	

				        	
				        	LocalDateTime DateTime = LocalDateTime.parse(datetime, formatter);
				        	
				        	
				        	
				        	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
				        	
				        	String datetime1=DateTime.format(formatter1);
				        	
				        	System.out.println(datetime1);
				        	
				        	d.put("datetime",datetime1);
				        	
				        	
				        	
				            
				            
				        }
				    }
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		
		model.addAttribute("batterydata",data);
		model.addAttribute("keys", keys);
		
		return viewname;
	}
	
	
	@GetMapping("/getbyid")
	public String getById(@RequestParam( value="id" , required = false) Long id,Model model) {
		String viewname="batterydatadisplay";
		if(id==null)return "batterydatawarning";
		
		BatteryData[] batterydata=template.getForObject("http://localhost:8081/batteryapi/batterydata/"+id, BatteryData[].class);
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		    for (BatteryData data : batterydata) {
		    	if(data.getDatetime()!=null)
		        data.setFormateddatetime(data.getDatetime().format(formatter));
		    }
		//System.out.print(batterydata[0]);
		model.addAttribute("batterydata",batterydata);
		
		
		return viewname;
		
	}
	
	@GetMapping("/batteryuserdemandconstraintentry")
	public String userDemandDateTime() {
		return "batteryuserdemanddatetimeentry";
	}
	
	@GetMapping("/userdemand/datetime")
	public String getByGivenTime(@RequestParam("batteryid")long batteryid,@RequestParam("variable") String variable,@ModelAttribute("constraintDateTime") ConstraintDateTime constraintDatetime,Model model){
		
		 HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_JSON);
	     
	     System.out.println(constraintDatetime.getStartdatetime()+"/n"+constraintDatetime.getEnddatetime());
	     
	     HttpEntity<ConstraintDateTime> requestEntity = new HttpEntity<>(constraintDatetime, headers);
	     
	     ResponseEntity<String> response =template.exchange("http://localhost:8081/batteryapi/batterydata/"+batteryid+"/"+variable+"/datetime",HttpMethod.POST, requestEntity, String.class);
		
	     String responseBody=null;
		
	     if (response.getStatusCode().is2xxSuccessful()) {
	            responseBody = response.getBody();
	            // Process the response
	        } else {
	            // Handle errors
	     
	        }
	     
	     ObjectMapper objectMapper = new ObjectMapper();
			
			Map<String,Object>[] data=null;
			
			try {
				  data=objectMapper.readValue(responseBody,new TypeReference<Map<String, Object>[]>() {});//we can use Map[].class but it gives warning
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}
			
			
			
			 String[] keys=null;
			try {
				keys = data[0].keySet().toArray(new String[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println(response.getBody());
			 
			 
			 try {
				if (data[0].containsKey("datetime")) {
					    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
					    for (Map<String, Object> d : data) {
					        if (d.get("datetime") != null) {
					        	
					        	String datetime=(String)d.get("datetime");
					        	
					        	
					        	LocalDateTime localDateTime = LocalDateTime.parse(datetime, formatter);
					        	
					        	DateTimeFormatter twelveHourFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");					        	
					        	String datetime1=localDateTime.format(twelveHourFormat);
					        	
					        	System.out.println(datetime1);
					        	
					        	d.put("datetime",datetime1);
					        }
					    }
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			model.addAttribute("batterydata",data);
			model.addAttribute("keys", keys);
			for(Map<String,Object> dataitem:data) {
				System.out.println(dataitem);
				System.out.println("......");
			}
	
	     
		return "batteryuserdemandview";
	}

}

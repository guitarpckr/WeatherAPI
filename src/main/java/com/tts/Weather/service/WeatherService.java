package com.tts.Weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.Weather.model.Zipcode;
import com.tts.Weather.repository.ZipcodeRepository;
import com.tts.Weather.response.Response;

@Service
public class WeatherService {
	
	@Autowired
	private ZipcodeRepository zipcodeRepository;
	
   @Value("${api_key}")
   private String apiKey;
   
   public Response getWeather(String zipCode) {
     String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
         zipCode + "&units=imperial&appid=" 
    	+ apiKey;
     RestTemplate restTemplate = new RestTemplate();
     List<Zipcode> zipcodeList = zipcodeRepository.findAll();
     Response response = new Response();
     try {
    	 response = restTemplate.getForObject(url,  Response.class);
    	 Zipcode zip = new Zipcode();
    	 zip.setZipcode(zipCode);
    	 zipcodeList.add(zip);
    	 saveZip(zip);
     }
     catch (HttpClientErrorException ex) {	
    	 response.setName("error");	 
     }
     return response;
   }
    
   public List<Zipcode> getLastTen() {
	   List<Zipcode> zipcodeList = zipcodeRepository.findAllByOrderByCreatedAtDesc();
	   List<Zipcode> lastTenZip = new ArrayList<>();
	   zipLoop:
	   for(Zipcode zip : zipcodeList) {
		   if(lastTenZip.size() < 10) {
			   lastTenZip.add(zip);
		   }else {
			   break zipLoop;
		   }
	   }
	   return lastTenZip;
   }
   
   public void saveZip(Zipcode zipcode) {
	   zipcodeRepository.save(zipcode);
   }
}

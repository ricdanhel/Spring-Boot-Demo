package com.example.webApi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class WebApiController {
	
	@RequestMapping(value = "/country/{countryName}", method = RequestMethod.GET)
	public String getCountryInfo(@PathVariable String countryName) throws IOException {
		String uri = "https://restcountries.eu/rest/v2/name/" + countryName;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		return response.getBody();
	}
	
	@GetMapping("/countries/all")
	public String getCountries() throws IOException {
		String uri = "https://restcountries.eu/rest/v2/all";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		return response.getBody();
	}
}

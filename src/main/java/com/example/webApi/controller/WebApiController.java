package com.example.webApi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WebApiController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String sayHi(@PathVariable String name) {
		return "Hoi " + name;
	}
	
	@GetMapping("/country/{countryName}")
	public String getCountryInfo(@PathVariable String countryName) throws IOException {
		String uri = "https://restcountries.eu/rest/v2/name/" + countryName;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.findPath("name");		
		
		return response.getBody();
	}
}



package com.tts.weatherapp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.weatherapp2.models.Request;
import com.tts.weatherapp2.models.Response;
import com.tts.weatherapp2.services.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	
	@GetMapping(path="/")
	public String getIndex(Model model) {		
		Request request = new Request();
		model.addAttribute("request", request);		
		return "index";
	}
	
	@PostMapping(path="/")
	public String postIndex(Request request, Model model) {
		Response response = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", response);
		model.addAttribute(weatherService);
		return "index";
	}
		
	
	
}


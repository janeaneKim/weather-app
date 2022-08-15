

package com.tts.weatherapp2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tts.weatherapp2.models.Response;
import com.tts.weatherapp2.models.ZipCode;
import com.tts.weatherapp2.repositories.ZipCodeRepository;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
		
	public Response getForecast(String zipCode) {
		UriComponents uri =
			UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.openweathermap.org")				
				.path("/data/2.5/weather")
				.queryParam("zip", zipCode+",us")
				.queryParam("units", "imperial")
				.queryParam("appid", apiKey)
				.build();
		
		String url = uri.encode().toUriString();
		System.out.println(url);
		
		RestTemplate restTemplate = new RestTemplate();
		Response response;
		try {
			response = restTemplate.getForObject(url, Response.class);
		} 
		catch (HttpClientErrorException e) {
			response = new Response();
			response.setName("error");
		}
		ZipCode zip = new ZipCode();
		zip.setZipCode(zipCode);
		zipCodeRepository.save(zip);
		
		
		return response;			
	}
	
	public List<ZipCode> recentSearches(){
		return zipCodeRepository.findFirst10ByOrderByCreatedTime();
	}
}


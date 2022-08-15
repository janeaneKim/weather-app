package com.tts.weatherapp2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.weatherapp2.models.ZipCode;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
	
		List<ZipCode>findFirst10ByOrderByCreatedTime();

}

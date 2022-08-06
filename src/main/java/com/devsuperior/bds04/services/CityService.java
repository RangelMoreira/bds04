package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	private static Logger logger = LoggerFactory.getLogger(CityService.class);
	
	@Autowired
	private CityRepository repository;
	
	//@Transactional(readOnly = true)
	public List<CityDTO> findAll(){
		List<City> list = repository.findAll();
		
		List<CityDTO> listDTO = list.stream().map(x -> new CityDTO(x))
				.collect(Collectors.toList());
		return (listDTO);
	}
	

}

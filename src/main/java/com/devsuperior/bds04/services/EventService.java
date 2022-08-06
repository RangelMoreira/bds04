package com.devsuperior.bds04.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {

	private static Logger logger = LoggerFactory.getLogger(EventService.class);

	@Autowired
	private EventRepository repository;

	//@Transactional(readOnly = true)
	public Page<EventDTO> find(PageRequest pageRequest) {
		Page<Event> page = repository.findAll(pageRequest);
		return page.map(x -> new EventDTO(x));

	}

}

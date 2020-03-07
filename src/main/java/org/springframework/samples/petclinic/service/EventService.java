package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Event;
import org.springframework.samples.petclinic.repository.springdatajpa.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Transactional
	public int eventCount() {
		return (int) eventRepo.count();
	}
	
	@Transactional
	public Iterable<Event> findAll(){
		return eventRepo.findAll();
	}
	
	@Transactional
	public void delete(Event event) {
		eventRepo.delete(event);
	}
	
	@Transactional
	public Optional<Event> findEventById(int id)  {
		return eventRepo.findById(id);
	}
	
	@Transactional
	public void save(Event event) {
		eventRepo.save(event);
	}

}

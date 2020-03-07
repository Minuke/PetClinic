package org.springframework.samples.petclinic.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Event;
import org.springframework.samples.petclinic.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	//LISTAR EVENTOS
	@GetMapping()
	public String listadoEventos(ModelMap modelMap) {
		String vista ="events/listadoEventos";
		Iterable<Event> events = eventService.findAll();
		modelMap.addAttribute("events", events);
		return vista;
	}
	
	
	@GetMapping(path="/delete/{eventId}")
	public String borrarEvento(@PathVariable("eventId") int eventId, ModelMap modelMap) {
		String view="events/listadoEventos";
		Optional<Event> event = eventService.findEventById(eventId);
		if(event.isPresent()) {
			eventService.delete(event.get());
			modelMap.addAttribute("message","Event successfully deleted!");
	
			
		}else {
			modelMap.addAttribute("message", "Event not found!");
			view=listadoEventos(modelMap);
		}
		return view;
	}

}

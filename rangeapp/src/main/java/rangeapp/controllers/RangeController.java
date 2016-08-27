package rangeapp.controllers;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rangeapp.models.Event;
import rangeapp.models.EventList;
import rangeapp.repositories.RangeRepository;

@RestController
@RequestMapping("rangeapi/products")
public class RangeController {
	
	@Autowired
	RangeRepository rangeRepository;
	
	@RequestMapping(value="{currentDate}/{previousDate}",method=RequestMethod.GET)
	@Path("{currentDate}/{previousDate}")
	public String getTodoById(@PathVariable("currentDate") String currentDate,@PathVariable("previousDate") String previousDate) {
		System.out.println("hi....");
		System.out.println("currentDate "+currentDate);
		System.out.println("previousDate "+previousDate);
		String result = rangeRepository.findProductsByEffectiveDate(currentDate,previousDate);
		
		return "Final Result: "+"\n"
		+result;
		
	}

	@RequestMapping(method=RequestMethod.POST)
	@POST
	public String createEvent(@RequestBody List<Event> eventlst) {
		//System.out.println("Event Received"+eventlst.get(0).toString());
		rangeRepository.saveEventList(eventlst);
		return "OK";
	}
	
	public RangeRepository getRangeRepository() {
		return rangeRepository;
	}


	public void setRangeRepository(RangeRepository rangeRepository) {
		this.rangeRepository = rangeRepository;
	}
	
}

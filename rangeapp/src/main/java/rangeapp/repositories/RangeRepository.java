package rangeapp.repositories;


import java.util.List;

import org.springframework.stereotype.Repository;

import rangeapp.models.Event;
import rangeapp.models.EventList;


@Repository
public interface RangeRepository {
	
	public String findProductsByEffectiveDate(String currentDate, String previousDate);
	public String saveEventList(List<Event> eventlst);
}

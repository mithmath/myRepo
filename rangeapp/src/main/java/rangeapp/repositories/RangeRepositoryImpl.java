package rangeapp.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import jersey.repackaged.com.google.common.collect.Sets;
import rangeapp.models.Event;
import rangeapp.models.EventList;

public class RangeRepositoryImpl implements RangeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoOperations mongoOperation;
	
	//MongoDBOpeartion mongoTemplate = new MongoTemplate();
	
	@Override
	public String findProductsByEffectiveDate(String currentDate, String previousDate) {
        
		Criteria criteria1 = Criteria.where("effectiveDate").is(currentDate);
		List<Event> currentData = mongoTemplate.find(Query.query(criteria1), Event.class);
		
		Criteria criteria2 = Criteria.where("effectiveDate").is(previousDate);
		List<Event> previousData = (mongoTemplate.find(Query.query(criteria2), Event.class));
		//extracting the product id from Event
		 List <String>productsWithCurrentDate = getProductIdFromList(currentData);
		 List <String>productsWithPreviousDate = getProductIdFromList(previousData);
		
		//Comparison logic
		Set<String> intersection = Sets.intersection(Sets.newHashSet(productsWithCurrentDate), Sets.newHashSet(productsWithPreviousDate));
		productsWithCurrentDate.removeAll(intersection);
		productsWithPreviousDate.removeAll(intersection);
		
		//Printing all the list
		printProductSet(intersection);
		printProductList(productsWithCurrentDate,"set2");
		printProductList(productsWithPreviousDate,"set3");
		
		return "Set1(YY):"+intersection.size()+"\n"+
				"Set2(YN):"+productsWithCurrentDate.size()+"\n"+
				"Set3(NY):"+productsWithPreviousDate.size();
		

	}
	
	@Override
	public String saveEventList(List<Event> eventlst) {
		//System.out.println("event22:"+event);
		for(Event evt:eventlst){
			
			mongoOperation.save(evt);
			
			System.out.println("event "+evt.getProduct()+"inserted");
		}
		
		return "OK";
	}

	private void printProductList(List<String> productsWithCurrentDate,String set) {
		for(String temp:productsWithCurrentDate ){
			System.out.println(set+":"+temp);
		}
	}


	private void printProductSet(Set<String> intersection) {
		for(String temp:intersection ){
			System.out.println("set1:"+temp);
		}
	}


	private List<String> getProductIdFromList(List<Event> eventData) {
		List<String> productList = new ArrayList<>();
		for(Event temp:eventData ){
			productList.add(temp.getProduct());
		}
		return productList;
	}


	

}

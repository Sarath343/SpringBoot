package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping(path = "/staticFiltered")
	public StaticFilterClass getFilteredObject() {
		return new StaticFilterClass("value1", "value2", "value3");
	}

	//for the below request some specific filters are applied on the object 
	@GetMapping(path = "/dynamicFiltering1")
	public MappingJacksonValue getDynamicFilterLogic1() {
		DynamicFilterClass dyna1 = new DynamicFilterClass("value1", "value2", "value2");

		MappingJacksonValue mappingValue = new MappingJacksonValue(dyna1);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","Field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someFilter", filter);

		mappingValue.setFilters(filters);
		return mappingValue;
	}
	@GetMapping(path = "/dynamicFiltering2")
	public MappingJacksonValue getDynamicFilterLogic2() {
		DynamicFilterClass dyna1 = new DynamicFilterClass("value1", "value2", "value2");

		MappingJacksonValue mappingValue = new MappingJacksonValue(dyna1);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someFilter", filter);

		mappingValue.setFilters(filters);
		return mappingValue;
	}
}

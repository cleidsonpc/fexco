package com.cleidsonpc.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleidsonpc.webapp.model.Person;
import com.cleidsonpc.webapp.service.PersonService;

@RestController
@RequestMapping(value="/webapp/persons", produces=MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Person person) {
		personService.save(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void update(@RequestBody Person person) {
		personService.update(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Person> findAll() {
		Iterable<Person> personList = personService.findAll();
		return personList;
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.GET, params={"test"}) |-> params={"test"} => ?test=1
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	public @ResponseBody Person findById(@PathVariable("id") Long id) {
		Person person = personService.findById(id);
		return person;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(@RequestBody Person person) {
		personService.delete(person);
	}
	
}

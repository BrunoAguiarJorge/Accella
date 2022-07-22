package com.accella.crud.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accella.crud.entities.Person;
import com.accella.crud.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonRESTResource {
		
	@Autowired
	private PersonService service;
	
	@GetMapping
	// create a list with all categories in it!
	public ResponseEntity<List<Person>> findAll() {
		List<Person> person = service.findAll();
		// "ok" return http code 200
		return ResponseEntity.ok().body(person);
	}

	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person person){
		person = service.insert(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).body(person);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) throws Exception{
		person = service.update(id, person);
		return ResponseEntity.ok().body(person);
	}
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Person> delete(@PathVariable Long id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
	}
	
	


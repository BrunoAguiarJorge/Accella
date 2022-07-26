package com.accella.crud.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accella.crud.entities.PersonAddress;
import com.accella.crud.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressRESTResource {

	@Autowired
	private AddressService service;

	@PostMapping
	public ResponseEntity<PersonAddress> insert(@RequestBody PersonAddress perAddress) {
		perAddress = service.insert(perAddress);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perAddress.getId()).toUri();
		return ResponseEntity.created(uri).body(perAddress);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonAddress> update(@PathVariable Long id, @RequestBody PersonAddress perAddress) throws Exception {
		perAddress = service.update(id, perAddress);
		return ResponseEntity.ok().body(perAddress);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PersonAddress> delete(@PathVariable Long id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

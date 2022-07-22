package com.accella.crud.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accella.crud.entities.Person;
import com.accella.crud.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	public PersonRepository repository;

	@Transactional
	public Person insert(Person per) {
		Person person = new Person();
		person.setFirstName(per.getFirstName());
		person.setLastName(per.getLastName());
		person = repository.save(person);
		return person;
	}

	@Transactional
	public Person update(Long id, Person per) throws Exception {
		try {
			Person person = repository.getReferenceById(id);
			person.setFirstName(per.getFirstName());
			person.setLastName(per.getLastName());
			person = repository.save(person);
			return person;
		} catch (EntityNotFoundException e) {
			throw new Exception("Id not found " + id);
		}
	}
}

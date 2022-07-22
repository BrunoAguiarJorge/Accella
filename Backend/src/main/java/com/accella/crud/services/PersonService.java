package com.accella.crud.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accella.crud.entities.Person;
import com.accella.crud.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	public PersonRepository repository;

	@Transactional(readOnly = true)
	public List<Person> findAll() {
		List<Person> list = repository.findAll();
		return list;
	}

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
	
	public void delete(Long id) throws Exception {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new Exception("Id not found " + id);
		}
	}
}

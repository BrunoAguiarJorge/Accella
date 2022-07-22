package com.accella.crud.services;

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
		person.setFirstName(person.getFirstName());
		person.setLastName(person.getLastName());
		person = repository.save(person);
		return person;		
	}
	
//	@Transactional
//	public Person update(Long id, Person dto) {
//		try {
//		Client entity = repository.getOne(id);
//		entity.setName(dto.getName());
//		entity.setCpf(dto.getCpf());
//		entity.setIncome(dto.getIncome());
//		entity.setBirthDate(dto.getBirthDate());
//		entity.setChildren(dto.getChildren());
//		entity = repository.save(entity);
//		return new Person(entity);	
//		}
//		catch (EntityNotFoundException e) {
//			throw new ResourceNotFoundException("Id not found " + id);
//		}
}

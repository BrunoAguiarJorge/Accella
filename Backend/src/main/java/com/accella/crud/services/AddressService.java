package com.accella.crud.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accella.crud.entities.Person;
import com.accella.crud.entities.PersonAddress;
import com.accella.crud.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	public AddressRepository repository;

	
	@Transactional
	public PersonAddress insert(PersonAddress perAddress) {
		PersonAddress address = new PersonAddress();
		address.setCity( perAddress.getCity());
		address.setStreet( perAddress.getStreet());
		address.setState(perAddress.getState());
		address.setPostalCode(perAddress.getPostalCode());
		address = repository.save(address);
		return address;
	}
	@Transactional
	public PersonAddress update(Long id, PersonAddress addr) throws Exception {

		PersonAddress address = repository.getReferenceById(id);
		address.setCity(addr.getCity());
		address.setStreet(addr.getStreet());
		address.setState(addr.getState());
		address.setPostalCode(addr.getPostalCode());
		address = repository.save(addr);
		return address;

	
//
//	public void delete(Long id) throws Exception {
//		try {
//			repository.deleteById(id);
//		} catch (EmptyResultDataAccessException e) {
//			throw new Exception("Id not found " + id);
//		}
	}
}

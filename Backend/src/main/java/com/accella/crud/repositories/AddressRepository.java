package com.accella.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accella.crud.entities.PersonAddress;

public interface AddressRepository extends JpaRepository<PersonAddress, Long> {

}

package com.accella.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accella.crud.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

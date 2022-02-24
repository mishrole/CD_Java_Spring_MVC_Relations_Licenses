package com.codingdojo.licenses.service;

import java.util.List;

import com.codingdojo.licenses.entity.Person;

public interface IPersonService {
	public abstract List<Person> allPersons();
	public abstract List<Person> allPersonsNotUsed();
	public abstract Person createPerson(Person person);
	public abstract Person findPerson(Long id);
	public abstract Person updatePerson(Long id, Person person);
	public abstract void deletePerson(Long id);
}

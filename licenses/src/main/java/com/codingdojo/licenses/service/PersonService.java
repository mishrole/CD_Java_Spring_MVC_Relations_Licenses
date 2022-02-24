package com.codingdojo.licenses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.licenses.entity.Person;
import com.codingdojo.licenses.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> allPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		
		return null;
	}

	@Override
	public Person updatePerson(Long id, Person person) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if (optionalPerson.isPresent()) {
			Person data = optionalPerson.get();
			data.setFirstName(person.getFirstName());
			data.setLastName(person.getLastName());
			//data.setLicense(person.getLicense());
			
			return personRepository.save(data);
		}
		
		return null;
	}

	@Override
	public void deletePerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if (optionalPerson.isPresent()) {
			personRepository.deleteById(id);
		}
		
	}

	@Override
	public List<Person> allPersonsNotUsed() {
		return personRepository.listAllNotUsed();
	}

}

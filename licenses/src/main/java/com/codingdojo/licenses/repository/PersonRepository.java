package com.codingdojo.licenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingdojo.licenses.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findAll();
	
	@Query(value = "Select * from Persons p left join Licenses l on p.id = l.person_id where p.Id not in ( Select p.id from Persons p, Licenses L where P.id = L.person_id)", nativeQuery = true)
	public abstract List<Person> listAllNotUsed();
}

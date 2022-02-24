package com.codingdojo.licenses.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.licenses.entity.Person;
import com.codingdojo.licenses.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	/* JSP */
	
	@RequestMapping()
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "persons/index";
	}
	
	@RequestMapping("/new")
	public String add(@ModelAttribute("person") Person person) {
		return "persons/new";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Person result = personService.findPerson(id);
		model.addAttribute("person", result);
		return "persons/edit";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person result = personService.findPerson(id);
		model.addAttribute("person", result);
		return "persons/show";
	}
	
	/* HTTP */
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "persons/new";
		}
		
		personService.createPerson(person);
		return "redirect:/persons";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "persons/edit";
		}
		
		personService.updatePerson(id, person);
		return "redirect:/persons";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		personService.deletePerson(id);
		return "redirect:/persons";
	}
}

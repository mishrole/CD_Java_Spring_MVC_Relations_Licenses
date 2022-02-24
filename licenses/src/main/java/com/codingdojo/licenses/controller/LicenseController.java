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

import com.codingdojo.licenses.entity.License;
import com.codingdojo.licenses.entity.Person;
import com.codingdojo.licenses.service.LicenseService;
import com.codingdojo.licenses.service.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private PersonService personService;
	
	/* JSP */
	
	@RequestMapping()
	public String index(Model model) {
		List<License> licenses = licenseService.allLicenses();
		model.addAttribute("licenses", licenses);
		
		return "licenses/index";
	}
	
	@RequestMapping("/new")
	public String add(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersonsNotUsed();
		model.addAttribute("persons_list", persons);
		return "licenses/new";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		License result = licenseService.findLicense(id);
		model.addAttribute("license", result);
		return "licenses/edit";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		License result = licenseService.findLicense(id);
		model.addAttribute("license", result);
		return "licenses/show";
	}
	
	/* HTTP */
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "licenses/new";
		}
		
		licenseService.createLicense(license);
		return "redirect:/licenses";
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "licenses/edit";
		}
		
		licenseService.updateLicense(id, license);
		return "redirect:/licenses";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		licenseService.deleteLicense(id);
		return "redirect:/licenses";
	}
}

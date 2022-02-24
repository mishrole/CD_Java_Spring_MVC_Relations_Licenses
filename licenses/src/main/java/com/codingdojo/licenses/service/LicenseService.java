package com.codingdojo.licenses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.licenses.entity.License;
import com.codingdojo.licenses.repository.LicenseRepository;

@Service
public class LicenseService implements ILicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;

	@Override
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}

	@Override
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}

	@Override
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		
		return null;
	}

	@Override
	public License updateLicense(Long id, License license) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		
		if (optionalLicense.isPresent()) {
			License data = optionalLicense.get();
			data.setNumber(license.getNumber());
			data.setExpirationDate(license.getExpirationDate());
			data.setState(license.getState());
			//data.setPerson(license.getPerson());
			
			return licenseRepository.save(data);
		}
		
		return null;
	}

	@Override
	public void deleteLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		
		if (optionalLicense.isPresent()) {
			licenseRepository.deleteById(id);
		}
		
	}
	
}

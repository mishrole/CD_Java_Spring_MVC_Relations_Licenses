package com.codingdojo.licenses.service;

import java.util.List;

import com.codingdojo.licenses.entity.License;

public interface ILicenseService {
	public abstract List<License> allLicenses();
	public abstract License createLicense(License license);
	public abstract License findLicense(Long id);
	public abstract License updateLicense(Long id, License license);
	public abstract void deleteLicense(Long id);
}

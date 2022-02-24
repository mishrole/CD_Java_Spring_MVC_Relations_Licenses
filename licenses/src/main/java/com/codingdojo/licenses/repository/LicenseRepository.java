package com.codingdojo.licenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.licenses.entity.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
	List<License> findAll();
}

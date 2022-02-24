package com.codingdojo.licenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SharedController {
	
	@RequestMapping("")
	public String index() {
		return "landing";
	}
	
}

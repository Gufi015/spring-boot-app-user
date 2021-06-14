package com.example.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Dev4jController {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

}

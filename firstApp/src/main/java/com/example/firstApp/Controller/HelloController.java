package com.example.firstApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value="/", method=RequestMethod.GET)//this line is quite long we can use diff annotationslike@GetMapping
	public String helloWorld() {
		return "Hello World..!!";
	}
	@GetMapping("/getMethod")//This can be used to handel the get requests
	public String helloGetMapping() {
		return "Heyyy You have implemented GetMapping shdgku";
	}
	

}

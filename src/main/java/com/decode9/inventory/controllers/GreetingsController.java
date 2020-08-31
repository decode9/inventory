package com.decode9.inventory.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.decode9.inventory.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greetings")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
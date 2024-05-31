package com.loggings.concepts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.loggings.concepts.serviceI.HomeServiceInterfaces;

@RestController
public class HomeController {

	@Autowired
	HomeServiceInterfaces homeServiceInterfaces;
	
	/*
	 * private: This keyword indicates that the LOGGER variable is accessible only
	 * within the class it is declared in. Other classes cannot directly access this
	 * variable.
	  
	 * static: The static keyword means that this variable belongs to the class, not
	 * to instances of the class. This means that there is only one LOGGER instance
	 * shared across all instances of the HomeController class. 
	
	 * final: The final keyword signifies that the value of the LOGGER variable
	 * cannot be changed once it is assigned. In other words, LOGGER is a constant
	 * reference. 

	 * Logger: This is an interface from the SLF4J API. It provides methods for
	 * logging messages at various levels (e.g., debug, info, warn, error).
	 
	 * LOGGER: This is the name of the variable that holds the Logger instance. By
	 * convention, static final variables are written in all uppercase letters with
	 * words separated by underscores.
	 
	 * LoggerFactory.getLogger(HomeController.class): This method call initializes
	 * the LOGGER variable.
	 
	 * LoggerFactory: This is a utility class provided by SLF4J to create Logger
	 * instances. getLogger(Class<?> Class): This method returns a logger for the
	 * specified class. In this case, it's the HomeController class.
	 
	 */
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/loggers/{username}/{password}")
	public String viewMessage(@PathVariable String username, @PathVariable String password)
	{
		LOGGER.error("This is Error");
		LOGGER.warn("This is Warning");
		LOGGER.debug("This is Debug");
		LOGGER.info("This is Information");
		
		homeServiceInterfaces.loginAuth(username, password);
		
		return "Logging Concepts";
		
	}
}

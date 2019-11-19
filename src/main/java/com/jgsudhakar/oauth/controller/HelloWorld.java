/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhakar.t
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/1.0")
public class HelloWorld {

	@GetMapping("/name")
	public String getMyName() {
		return "Welcome to OAuth World, SUdhakar!";
	}
}

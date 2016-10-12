package com.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

	@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "text/plain")
	public String hello() throws UnknownHostException {

		String hostname = null;
		String address = null;
		
		try {
			hostname = InetAddress.getLocalHost().getHostName();
			address = InetAddress.getLocalHost().getHostAddress();

		} catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return "Hello Spring Boot from " + hostname + " with address: " + address;
	}
}

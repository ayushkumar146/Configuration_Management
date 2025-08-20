// This is the package name (like a folder where this file lives)
// It helps keep code organized in different boxes
package com.cloud.config;

// These are "imports". They bring tools from Spring Boot and Spring Cloud
// so we can use them in our program without writing all code ourselves.
import org.springframework.boot.SpringApplication;   // Helps to run a Spring Boot app
import org.springframework.boot.autoconfigure.SpringBootApplication; // Tells Spring Boot this is the main app
import org.springframework.cloud.config.server.EnableConfigServer;   // Lets us make this app a Config Server

// @SpringBootApplication is a "magic sticker" that says:
// 1. This is a Spring Boot app
// 2. Turn on auto-configuration (Spring sets up things for us automatically)
// 3. Look for components (beans) in this package and below
@SpringBootApplication

// @EnableConfigServer is another "magic sticker" that says:
// "Hey Spring, turn this app into a Config Server"
// Config Server is like a library where other microservices come
// to get their settings (like their usernames, passwords, or URLs).
@EnableConfigServer
public class ConfigApplication {

	// This is the "main" method. Every Java program starts from here.
	// It tells Spring Boot: "Okay, start my app!"
	public static void main(String[] args) {
		// SpringApplication.run(...) starts the app
		// Think of it like pressing the "ON" button of a machine.
		SpringApplication.run(ConfigApplication.class, args);
	}
}

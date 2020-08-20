package com.example.translate.rest.api.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.example.translate.rest.api.clients.JaxRsTutorialRestClientImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan("com.example.translate.rest.api.clients")
@SpringBootApplication
public class TutorialApplication implements CommandLineRunner {

	@Autowired
	JaxRsTutorialRestClientImpl jaxClient;

	@Autowired
	private ObjectMapper mapper;

	public static void main(String[] args) {
		new SpringApplicationBuilder(TutorialApplication.class).web(WebApplicationType.NONE).run(args);
	}

	@Override
	public void run(String... args) {
		System.out.println("works");
	/*	System.out.println(jaxClient.getSupportedLanguages("en"));
		try {
			System.out.println(mapper.writeValueAsString(
					jaxClient.detectLanguage("This is a test. Can it translate this to english? We will see.")));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
		try {
			System.out.println(mapper.writeValueAsString(jaxClient.translate("How are you", "hi", null)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	/*	try {
			System.out.println(mapper.writeValueAsString(jaxClient.translate("Hola, como estas?", "pt", "es")));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
	}
}
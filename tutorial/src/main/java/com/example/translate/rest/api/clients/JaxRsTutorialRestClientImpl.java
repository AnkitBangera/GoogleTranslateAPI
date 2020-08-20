package com.example.translate.rest.api.clients;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import org.springframework.stereotype.Component;
import com.example.translate.rest.api.json.object.Detection;
import com.example.translate.rest.api.json.object.GoogleTranslateObject;
import com.example.translate.rest.api.json.object.Language;
import com.example.translate.rest.api.json.object.Translation;

@Component
public class JaxRsTutorialRestClientImpl extends TutorialRestClient {

	Client client;
	WebTarget baseTarget;

	@PostConstruct
	private void postConstruct() {
		client = ClientBuilder.newClient();
		baseTarget = client.target(this.endpointBase);
	}

	@Override
	public List<Language> getSupportedLanguages(String targetLanguage) {
		MultivaluedMap<String, Object> myHeaders = super.createRapidApiHeaders();
		WebTarget languagesTarget = baseTarget.path(this.languagesEndpoint);
		GoogleTranslateObject translateObject = languagesTarget.queryParam("target", targetLanguage)
				.request(MediaType.APPLICATION_JSON).headers(myHeaders).get(GoogleTranslateObject.class);
		return translateObject.getData().getLanguages();
	}

	public MultivaluedMap<String, Object> createRapidApiHeaders() {
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(this.rapidApiHost, this.rapidApiHostValue);
		myHeaders.add(this.rapidApiKey, this.rapidApiKeyValue);
		return myHeaders;
	}

	@Override
	public List<List<Detection>> detectLanguage(String inputString) {
		Form formData = new Form();
		formData.param("q", inputString);
		WebTarget detectTarget = baseTarget.path(this.detectEndpoint);
		GoogleTranslateObject translateObject = detectTarget.request(MediaType.APPLICATION_JSON)
				.headers(super.createRapidApiHeaders()).post(Entity.form(formData), GoogleTranslateObject.class);
		return translateObject.getData().getDetections();
	}

	@Override
	public List<Translation> translate(String inputString, String targetLanguage, String sourceLanguage) {

		Form formData = new Form();
		formData.param("q", inputString);
		formData.param("target", targetLanguage);
		if (sourceLanguage != null) {
			formData.param("source", sourceLanguage);
		}
		WebTarget translateTarget = baseTarget.path(this.translateEndpoint);
		GoogleTranslateObject translateObject = translateTarget.request(MediaType.APPLICATION_JSON)
				.headers(super.createRapidApiHeaders()).post(Entity.form(formData), GoogleTranslateObject.class);
		return translateObject.getData().getTranslations();
	}
}
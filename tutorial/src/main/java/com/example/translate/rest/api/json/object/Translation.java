package com.example.translate.rest.api.json.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Translation {
	public String translatedText;
	public String detectedSourceLanguage;
	
	public Translation() {
		
	}

	public Translation(String translatedText, String detectedSourceLanguage) {
		this.translatedText = translatedText;
		this.detectedSourceLanguage = detectedSourceLanguage;
	}

	public String getDetectedSourceLanguage() {
		return detectedSourceLanguage;
	}

	public void setDetectedSourceLanguage(String detectedSourceLanguage) {
		this.detectedSourceLanguage = detectedSourceLanguage;
	}

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	public String toString() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package com.example.translate.rest.api.json.object;

import java.util.List;

public class Data {
	private List<Language> languages = null;
	private List<List<Detection>> detections = null;
	private List<Translation> translations = null;
	
	public Data() {
	
	}

	public Data(List<Language> languages, List<List<Detection>> detections, List<Translation> translations) {
		super();
		this.languages = languages;
		this.detections = detections;
		this.translations = translations;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<List<Detection>> getDetections() {
		return detections;
	}

	public void setDetections(List<List<Detection>> detections) {
		this.detections = detections;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}
}

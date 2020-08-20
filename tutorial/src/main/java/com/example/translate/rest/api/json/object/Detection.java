package com.example.translate.rest.api.json.object;

public class Detection {
	private Boolean isReliable;
	private String language;
	private Integer confidence;
	public Detection() {
	}
	public Detection(Boolean isReliable, String language, Integer confidence) {
		this.isReliable = isReliable;
		this.language = language;
		this.confidence = confidence;
	}

	public Boolean getIsReliable() {
		return isReliable;
	}

	public void setIsReliable(Boolean isReliable) {
		this.isReliable = isReliable;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}
}

package com.example.translate.rest.api.json.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class Language {
  public String language;
  public String name;
  
  public Language() {
	
}
  public Language(String language, String name) {
	this.language = language;
	this.name = name;
}
public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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

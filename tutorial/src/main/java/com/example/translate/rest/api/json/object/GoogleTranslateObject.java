package com.example.translate.rest.api.json.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class GoogleTranslateObject {
  private Data data;
  public GoogleTranslateObject() {
		
	}
  
  public GoogleTranslateObject(Data data) {
	super();
	this.data = data;
}
public Data getData() {
    return data;
  }
  public void setData(Data data) {
    this.data = data;
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

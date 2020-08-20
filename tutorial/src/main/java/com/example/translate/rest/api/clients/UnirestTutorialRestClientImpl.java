package com.example.translate.rest.api.clients;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.translate.rest.api.json.object.Detection;
import com.example.translate.rest.api.json.object.Language;
import com.example.translate.rest.api.json.object.Translation;

@Component
public class UnirestTutorialRestClientImpl extends TutorialRestClient {

  @Override
  public List<Language> getSupportedLanguages(String targetLanguage) {
    return null;
  }

  @Override
  public List<List<Detection>> detectLanguage(String inputString) {
    return null;
  }

  @Override
  public List<Translation> translate(String inputString, String targetLanguage, String sourceLanguage) {
    return null;
  }
}
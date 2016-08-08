package com.apischan.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Build a sentence by assembling randomly generated subjects, verbs,
 * articles, adjectives, and nouns. The individual parts of speech will
 * be obtained by calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    private WordService wordService;

    @Override
    public String buildSentence() {
        return MessageFormat.format("{0} {1} {2}",// {3} {4}.",
//                wordService.getSubject().getWord(),
//                wordService.getVerb().getWord(),
                wordService.getArticle().getWord(),
                wordService.getAdjective().getWord(),
                wordService.getNoun().getWord()
        );
    }

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }
}

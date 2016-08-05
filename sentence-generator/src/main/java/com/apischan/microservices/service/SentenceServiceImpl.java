package com.apischan.microservices.service;

import com.apischan.microservices.dao.WordDao;
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

    private WordDao verbService;
    private WordDao subjectService;
    private WordDao articleService;
    private WordDao adjectiveService;
    private WordDao nounService;

    @Override
    public String buildSentence() {
        return MessageFormat.format("{1} {2} {3} {4} {5}.",
                subjectService.getWord().getWord(),
                verbService.getWord().getWord(),
                articleService.getWord().getWord(),
                adjectiveService.getWord().getWord(),
                nounService.getWord().getWord()
        );
    }

    @Autowired
    public void setVerbService(WordDao verbService) {
        this.verbService = verbService;
    }

    @Autowired
    public void setSubjectService(WordDao subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setArticleService(WordDao articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setAdjectiveService(WordDao adjectiveService) {
        this.adjectiveService = adjectiveService;
    }

    @Autowired
    public void setNounService(WordDao nounService) {
        this.nounService = nounService;
    }
}

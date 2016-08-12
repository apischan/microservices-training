package com.apischan.microservices.service;

import com.apischan.microservices.dao.*;
import com.apischan.microservices.domain.Word;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    private VerbClient verbClient;
    private SubjectClient subjectClient;
    private ArticleClient articleClient;
    private AdjectiveClient adjectiveClient;
    private NounClient nounClient;

    @HystrixCommand(fallbackMethod = "getSubjectFallback")
    @Override
    public Word getSubject() {
        return subjectClient.getWord();
    }

    @HystrixCommand(fallbackMethod = "getVerbFallBack")
    @Override
    public Word getVerb() {
        return verbClient.getWord();
    }

    @HystrixCommand(fallbackMethod = "getArticleFallback")
    @Override
    public Word getArticle() {
        return articleClient.getWord();
    }

    @HystrixCommand(fallbackMethod = "getAdjectiveFallback")
    @Override
    public Word getAdjective() {
        return adjectiveClient.getWord();
    }

    @HystrixCommand(fallbackMethod = "getNounFallback")
    @Override
    public Word getNoun() {
        return nounClient.getWord();
    }

    //---------------fallbacks-------------------------------------

    public Word getSubjectFallBack() {
        return new Word("Someone");
    }

    public Word getVerbFallBack() {
        return new Word("do");
    }

    public Word getArticleFallback() {
        return new Word("");
    }

    public Word getAdjectiveFallback() {
        return new Word("hello");
    }

    public Word getNounFallback() {
        return new Word("somthing");
    }

    //-----------------autowirings------------------------------

    @Autowired
    public void setVerbClient(VerbClient verbClient) {
        this.verbClient = verbClient;
    }

    @Autowired
    public void setSubjectClient(SubjectClient subjectClient) {
        this.subjectClient = subjectClient;
    }

    @Autowired
    public void setArticleClient(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    @Autowired
    public void setAdjectiveClient(AdjectiveClient adjectiveClient) {
        this.adjectiveClient = adjectiveClient;
    }

    @Autowired
    public void setNounClient(NounClient nounClient) {
        this.nounClient = nounClient;
    }
}

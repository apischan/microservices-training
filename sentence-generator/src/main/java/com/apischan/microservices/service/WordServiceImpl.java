package com.apischan.microservices.service;

import com.apischan.microservices.dao.*;
import com.apischan.microservices.domain.Word;
import com.apischan.microservices.service.command.WordCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

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
//        return Observable.just(subjectClient.getWord());
//        return new WordCommand<>(subjectClient)
//                .observe();
    }

    @HystrixCommand(fallbackMethod = "getVerbFallback")
    @Override
    public Word getVerb() {
        return verbClient.getWord();
//        return Observable.just(verbClient.getWord());
//        return new WordCommand<>(verbClient)
//                .observe();
    }

    @HystrixCommand(fallbackMethod = "getArticleFallback")
    @Override
    public Word getArticle() {
        return articleClient.getWord();
//        return Observable.just(articleClient.getWord());
//        return new WordCommand<>(articleClient)
//                .observe();
    }

    @HystrixCommand(fallbackMethod = "getAdjectiveFallback")
    @Override
    public Word getAdjective() {
        return adjectiveClient.getWord();
//        return Observable.just(adjectiveClient.getWord());
//        return new WordCommand<>(adjectiveClient)
//                .toObservable();
    }

    @HystrixCommand(fallbackMethod = "getNounFallback")
    @Override
    public Word getNoun() {
        return nounClient.getWord();
//        return Observable.just(nounClient.getWord());
//        return new WordCommand<>(nounClient)
//                .observe();
    }

//    //----------------fallbacks-----------------------------------------------------------

    public Word getSubjectFallback() {
        return new Word(
                "Someone",
                Word.Role.SUBJECT
        );
    }

    public Word getVerbFallback() {
        return new Word(
                "do",
                Word.Role.VERB
        );
    }

    public Word getArticleFallback() {
        return new Word(
                "the",
                Word.Role.ARTICLE
        );
    }

    public Word getAdjectiveFallback() {
        return new Word(
                "any",
                Word.Role.ADJECTIVE
        );
    }

    public Word getNounFallback() {
        return new Word(
                "something",
                Word.Role.NOUN
        );
    }

    //----------------autowirings---------------------------------------------------------
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

package com.apischan.microservices.service;

import com.apischan.microservices.dao.*;
import com.apischan.microservices.domain.Word;
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

    @Override
    public Observable<Word> getSubject() {
        return Observable.just(subjectClient.getSubject());
    }

    @Override
    public Observable<Word> getVerb() {
        return Observable.just(verbClient.geVerb());
    }

    @Override
    public Observable<Word> getArticle() {
        return Observable.just(articleClient.getArticle());
    }

    @Override
    public Observable<Word> getAdjective() {
        return Observable.just(adjectiveClient.getAdjective());
    }

    @Override
    public Observable<Word> getNoun() {
        return Observable.just(nounClient.getNoun());
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

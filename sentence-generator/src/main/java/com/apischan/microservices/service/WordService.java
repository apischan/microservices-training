package com.apischan.microservices.service;

import com.apischan.microservices.domain.Word;
import rx.Observable;

public interface WordService {

//    Observable<Word> getSubject();
//    Observable<Word> getVerb();
//    Observable<Word> getArticle();
//    Observable<Word> getAdjective();
//    Observable<Word> getNoun();

    Word getSubject();
    Word getVerb();
    Word getArticle();
    Word getAdjective();
    Word getNoun();

}

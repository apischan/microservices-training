package com.apischan.microservices.service;

import com.apischan.microservices.domain.Word;

public interface WordService {

    Word getSubject();
    Word getVerb();
    Word getArticle();
    Word getAdjective();
    Word getNoun();

}

package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;

public interface WordDao {
    String SUBJECT = "SUBJECT";
    String VERB = "VERB";
    String ARTICLE = "ARTICLE";
    String ADJECTIVE = "ADJECTIVE";
    String NOUN = "NOUN";

    Word getWord();
}

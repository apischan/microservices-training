package com.apischan.microservices.dao;

import org.springframework.stereotype.Component;

@Component("verbService")
public class VerbDaoImpl extends WordDaoImpl {

    @Override
    String getPartOfSpeech() {
        return VERB;
    }

}

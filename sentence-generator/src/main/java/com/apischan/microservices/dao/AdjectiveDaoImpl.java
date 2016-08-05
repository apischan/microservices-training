package com.apischan.microservices.dao;

import org.springframework.stereotype.Component;

@Component("adjectiveService")
public class AdjectiveDaoImpl extends WordDaoImpl {

    @Override
    String getPartOfSpeech() {
        return ADJECTIVE;
    }

}

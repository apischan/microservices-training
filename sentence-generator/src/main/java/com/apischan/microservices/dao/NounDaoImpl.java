package com.apischan.microservices.dao;

import org.springframework.stereotype.Component;

@Component("nounService")
public class NounDaoImpl extends WordDaoImpl {

    @Override
    String getPartOfSpeech() {
        return NOUN;
    }

}

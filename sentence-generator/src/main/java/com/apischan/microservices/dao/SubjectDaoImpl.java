package com.apischan.microservices.dao;

import org.springframework.stereotype.Component;

@Component("subjectService")
public class SubjectDaoImpl extends WordDaoImpl {

    @Override
    String getPartOfSpeech() {
        return SUBJECT;
    }

}

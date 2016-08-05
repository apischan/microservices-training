package com.apischan.microservices.dao;

import org.springframework.stereotype.Component;

@Component("articleService")
public class ArticleDaoImpl extends WordDaoImpl {

    @Override
    String getPartOfSpeech() {
        return ARTICLE;
    }

}

package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;

public interface WordClient {

    Word getWord();

//    Word getFallback();
}

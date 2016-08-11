package com.apischan.microservices.service.command;

import com.apischan.microservices.dao.WordClient;
import com.apischan.microservices.domain.Word;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class WordCommand<T extends WordClient> {// extends HystrixCommand<Word> {

//    private T wordClient;
//
//    public WordCommand(T wordClient) {
//        super(HystrixCommandGroupKey.Factory.asKey(wordClient.getClass().getName()));
//        this.wordClient = wordClient;
//    }
//
//    @Override
//    protected Word run() throws Exception {
//        return wordClient.getWord();
//    }
//
//    @Override
//    protected Word getFallback() {
//        return new Word("aaa", Word.Role.ADJECTIVE);
//        //return wordClient.getFallback();
//    }
}

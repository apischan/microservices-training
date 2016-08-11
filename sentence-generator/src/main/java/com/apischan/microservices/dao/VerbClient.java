package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.apischan.microservices.domain.Word.*;

@FeignClient("verb-generator")
public interface VerbClient extends WordClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getWord();
//
//    @Override
//    default Word getFallback() {
//        return new Word("do", Role.VERB);
//    }
}

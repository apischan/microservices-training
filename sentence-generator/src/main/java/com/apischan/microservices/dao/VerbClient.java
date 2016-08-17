package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "verb-generator", fallback = VerbClient.VerbClientFallback.class)
public interface VerbClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word geVerb();

    @Component
    class VerbClientFallback implements VerbClient {

        @Override
        public Word geVerb() {
            return new Word("do", Word.Role.VERB);
        }
    }
}


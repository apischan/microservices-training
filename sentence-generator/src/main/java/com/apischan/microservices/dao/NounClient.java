package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "noun-generator", fallback = NounClient.NounClientFallback.class)
public interface NounClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getNoun();

    @Component
    class NounClientFallback implements NounClient {

        @Override
        public Word getNoun() {
            return new Word("something", Word.Role.NOUN);
        }
    }
}


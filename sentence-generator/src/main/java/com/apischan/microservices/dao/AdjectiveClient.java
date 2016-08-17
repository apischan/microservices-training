package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "adjective-generator", fallback = AdjectiveClient.AdjectiveClientFallback.class)
public interface AdjectiveClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getAdjective();

    @Component
    class AdjectiveClientFallback implements AdjectiveClient {

        @Override
        public Word getAdjective() {
            return new Word("any", Word.Role.ADJECTIVE);
        }
    }
}

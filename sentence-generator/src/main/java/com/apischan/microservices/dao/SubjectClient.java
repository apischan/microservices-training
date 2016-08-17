package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "subject-generator", fallback = SubjectClient.SubjectClientFallback.class)
public interface SubjectClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getSubject();

    @Component
    class SubjectClientFallback implements SubjectClient {

        @Override
        public Word getSubject() {
            return new Word("Someone", Word.Role.SUBJECT);
        }
    }
}

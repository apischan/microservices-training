package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import com.apischan.microservices.domain.Word.Role;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("article-generator")
public interface ArticleClient extends WordClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getWord();

//    @Override
//    default Word getFallback() {
//        return new Word("", Role.ARTICLE);
//    }
}

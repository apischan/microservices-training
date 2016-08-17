package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "article-generator", fallback = ArticleClient.ArticleClientFallback.class)
public interface ArticleClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getArticle();

    @Component
    class ArticleClientFallback implements ArticleClient {

        @Override
        public Word getArticle() {
            return new Word("", Word.Role.ARTICLE);
        }
    }
}

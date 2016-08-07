package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("noun-generator")
public interface NounClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    Word getWord();

}

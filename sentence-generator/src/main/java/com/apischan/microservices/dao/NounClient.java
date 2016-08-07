package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("sentence-generator")
public interface NounClient {

    Word getWord();

}

package com.apischan.microservices.controller;

import com.apischan.microservices.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.StringJoiner;

@RestController
public class SentenceFeignController {
    private SentenceService sentenceService;

    @Autowired
    public SentenceFeignController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return sentenceService.buildSentence();
    }

}

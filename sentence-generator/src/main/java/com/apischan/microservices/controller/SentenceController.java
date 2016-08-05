package com.apischan.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.StringJoiner;

@RestController
public class SentenceController {

    private LoadBalancerClient client;

    @Autowired
    public SentenceController(LoadBalancerClient client) {
        this.client = client;
    }

    @RequestMapping("/sentence")
    public @ResponseBody String getSentence() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(getWord("SUBJECT-GENERATOR"))
                .add(getWord("VERB-GENERATOR"))
                .add(getWord("ARTICLE-GENERATOR"))
                .add(getWord("ADJECTIVE-GENERATOR"))
                .add(getWord("NOUN-GENERATOR"));
        return stringJoiner.toString();
    }

    private String getWord(String service) {
        ServiceInstance serviceInstance = client.choose(service);
        if (serviceInstance != null) {
            URI uri = serviceInstance.getUri();
            if (uri != null) {
                return new RestTemplate()
                        .getForObject(uri,String.class);
            }
        }
        return null;
    }

}

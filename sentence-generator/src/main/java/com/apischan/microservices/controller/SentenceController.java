package com.apischan.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.StringJoiner;

@RestController
public class SentenceController {

    private DiscoveryClient client;

    @Autowired
    public SentenceController(DiscoveryClient discoveryClient) {
        this.client = discoveryClient;
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
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return new RestTemplate()
                        .getForObject(uri,String.class);
            }
        }
        return null;
    }

}

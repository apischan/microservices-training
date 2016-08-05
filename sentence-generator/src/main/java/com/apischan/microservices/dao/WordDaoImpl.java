package com.apischan.microservices.dao;

import com.apischan.microservices.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

public abstract class WordDaoImpl implements WordDao {

    private LoadBalancerClient loadBalancer;

    abstract String getPartOfSpeech();

    public Word getWord() {
        ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
        return new RestTemplate()
                .getForObject(instance.getUri(), Word.class);
    }

    @Autowired
    public void setLoadBalancer(LoadBalancerClient loadBalancer) {
        this.loadBalancer = loadBalancer;
    }
}

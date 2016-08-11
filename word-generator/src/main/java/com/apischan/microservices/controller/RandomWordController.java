package com.apischan.microservices.controller;

import com.apischan.microservices.domain.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.apischan.microservices.domain.Word.*;

@RestController
public class RandomWordController {

    @Value("${words}") String words;
    @Value("${spring.profiles.active}") String profile;

    @RequestMapping("/")
    public @ResponseBody Word getWord() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return new Word(wordArray[i], Role.getRole(profile));
    }

}

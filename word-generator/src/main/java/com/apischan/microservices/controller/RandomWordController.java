package com.apischan.microservices.controller;

import com.apischan.microservices.domain.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomWordController {

    @Value("${words}") String words;

    @RequestMapping("/")
    public @ResponseBody Word getWord() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return new Word(wordArray[i]);
    }

}

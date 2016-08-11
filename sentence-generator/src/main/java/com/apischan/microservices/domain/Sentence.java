package com.apischan.microservices.domain;

import com.apischan.microservices.domain.Word.Role;
import lombok.Data;

import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
public class Sentence {

    private Map<Role, String> words = new EnumMap<>(Role.class);

    public void addWord(Word word) {
        words.put(word.getRole(), word.getWord());
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ")
                .add(words.get(Role.SUBJECT))
                .add(words.get(Role.VERB))
                .add(words.get(Role.ARTICLE))
                .add(words.get(Role.ADJECTIVE))
                .add(words.get(Role.NOUN));

        return joiner.toString();
    }
}

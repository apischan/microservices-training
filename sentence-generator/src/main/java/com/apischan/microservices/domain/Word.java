package com.apischan.microservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    private String word;

    private Role role;

    public enum Role {
        SUBJECT("subject"),
        VERB("verb"),
        ARTICLE("article"),
        ADJECTIVE("adjective"),
        NOUN("noun"),
        UNKNOWN("");

        private String role;

        Role(String role) {
            this.role = role;
        }

        public static Role getRole(String roleName) {
            return Stream.of(values())
                    .filter(r -> r.role.equals(roleName))
                    .findFirst().orElse(Role.UNKNOWN);
        }
    }

}

package com.deadlock.hack.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class CommentDto {
    @NonNull
    private final String comment;

    @JsonCreator
    public CommentDto(@JsonProperty("comment") final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}

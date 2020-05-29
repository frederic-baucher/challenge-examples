package com.deadlock.hack.model;

import org.springframework.lang.NonNull;

public class Comment {
    private final int id;
    @NonNull
    private final String content;
    private final int catId;
    private final String who;

    public Comment(final int id, final String content, final int catId, String who) {
        this.id = id;
        this.content = content;
        this.catId = catId;
        this.who = who;
    }
}

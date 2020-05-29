package com.deadlock.hack.model;

public class Cat {

    private int id;
    private String name;
    private String url;

    public Cat(final int id, final String name, final String url) {
        this(name, url);
        this.id = id;
    }

    public Cat(final String name, final String url) {
        this.name = name;
        this.url = url;
    }
}

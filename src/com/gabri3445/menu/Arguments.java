package com.gabri3445.menu;

public class Arguments {
    protected Runnable action;
    protected String description;

    public Arguments(Runnable action, String description) {
        this.action = action;
        this.description = description;
    }
}
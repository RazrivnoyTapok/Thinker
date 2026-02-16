package com.example.thinker;

import java.util.concurrent.atomic.AtomicInteger;

public class Knowledge {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_BANANA = 1;
    public static final int TYPE_APPLE = 2;

    private static final AtomicInteger nextId = new AtomicInteger(0);
    private final int id;
    private final String cardTitle;
    private final String cardDescription;
    private final int type;

    public Knowledge(String t, String d, int type) {
        this.id = nextId.getAndIncrement();
        this.cardTitle = t;
        this.cardDescription = d;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public int getType() {
        return type;
    }
}
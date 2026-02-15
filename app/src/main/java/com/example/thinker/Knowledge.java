package com.example.thinker;

import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class Knowledge {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_BANANA = 1;
    public static final int TYPE_APPLE = 2;

    private static final AtomicInteger nextId = new AtomicInteger(0);
    private final int id;
    private final String cardTitle;
    private final String cardDescription;
    private final TextView activitySignature;
    private final int type;

    public Knowledge(String t, String d, TextView tv, int type) {
        this.id = nextId.getAndIncrement();
        this.cardTitle = t;
        this.cardDescription = d;
        this.activitySignature = tv;
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

    public TextView getActivitySignature() {
        return activitySignature;
    }

    public int getType() {
        return type;
    }
}
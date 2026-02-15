package com.example.thinker;

import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class Knowledge {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private final int id;
    private final String cardTitle;
    private final String cardDescription;
    private final TextView activitySignature;


    public Knowledge(String t, String d, TextView tv) {
        this.id = nextId.getAndIncrement();
        this.cardTitle = t;
        this.cardDescription = d;
        this.activitySignature = tv;
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
}

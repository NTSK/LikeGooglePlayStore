package com.store.play.like.ntsk.likegoogleplaystore;


public class AppData {
    private int drawableId;
    private String name;
    private String score;

    public AppData(int drawableId, String name, String score) {
        this.drawableId = drawableId;
        this.name = name;
        this.score = score;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}

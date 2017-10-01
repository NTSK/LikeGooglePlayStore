package com.store.play.like.ntsk.likegoogleplaystore;


class AppData {
    private int drawableId;
    private String name;
    private String score;

    AppData(int drawableId, String name, String score) {
        this.drawableId = drawableId;
        this.name = name;
        this.score = score;
    }

    int getDrawableId() {
        return drawableId;
    }

    String getName() {
        return name;
    }

    String getScore() {
        return score + "★";
    }
}

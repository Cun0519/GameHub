package com.cunxie.gamehub;

import android.content.Context;
import android.content.Intent;

import com.cunxie.gamehub.Util.Signal;

public class Game {
    private String name;
    private int imageId;
    private Intent intent;

    public Game(String name, int imageId, Intent intent) {
        this.name = name;
        this.imageId = imageId;
        this.intent = intent;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void goToGame(Context context) {
        if (this.intent != null) {
           context.startActivity(this.intent);
        } else {
            Signal.signalAlertDialog(context);
        }
    }
}

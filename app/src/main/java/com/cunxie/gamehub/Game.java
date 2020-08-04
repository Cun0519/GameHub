package com.cunxie.gamehub;

import android.content.Context;
import android.content.Intent;
import com.cunxie.gamehub.Activity.AvalonMainActivity;
import com.cunxie.gamehub.Util.Signal;

public class Game {

    private String name;
    private int imageId;

    public Game(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void goToGame(Context context) {
        switch (this.name) {
            case "Avalon":
                context.startActivity(new Intent(context, AvalonMainActivity.class));
                break;
            default:
                Signal.signalAlertDialog(context);
                break;
        }
    }
}

package com.cunxie.gamehub;

import android.content.Context;
import android.content.Intent;
import com.cunxie.gamehub.Activity.AvalonContentActivity;

public class AvalonRole {

    private String name;
    private int imageId;
    private String content;

    public AvalonRole(String name, int imageId, String content) {
        this.name = name;
        this.imageId = imageId;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }

    public String getContent() {
        return this.content;
    }

    public void goToContent(Context context) {
        Intent intent = new Intent(context, AvalonContentActivity.class);
        intent.putExtra("name", this.name);
        intent.putExtra("imageId", this.imageId);
        intent.putExtra("content", this.content);
        context.startActivity(intent);
    }

}

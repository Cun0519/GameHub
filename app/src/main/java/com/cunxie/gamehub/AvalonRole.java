package com.cunxie.gamehub;

import android.content.Context;
import android.content.Intent;

import com.cunxie.gamehub.Activity.AvalonContentActivity;

import java.io.Serializable;

public class AvalonRole implements Serializable {

    private String name;
    private int imageId;
    private String content;

    public AvalonRole(String name) {
        this.name = name;
        switch (name) {
            case "梅林":
                this.imageId = R.drawable.meilin;
                this.content = "好人方的主公，他能看到除了黑老大之外的所有坏人，他需要在游戏中隐藏自己，给派西维尔透露信息。";
                break;
            case "派西维尔":
                this.imageId = R.drawable.paixiweier;
                this.content = "好人方的带队人，他能看到莫甘娜和梅林，但不知道谁是真正的梅林，他需要确定真正的梅林，然后带领好人方组队赢得游戏。";
                break;
            case "忠臣":
                this.imageId = R.drawable.zhongchen;
                this.content = "好人方的成员，他们只能看到自己的身份牌，需要跟随派西维尔的领导让任务成功，并且隐藏真正的梅林身份。";
                break;
            case "莫甘娜":
                this.imageId = R.drawable.moganna;
                this.content = "坏人方的领头人，莫甘娜能看见除奥伯伦之外的坏人，同时他能被梅林看见，他可以被派西维尔看见，但派西维尔并不知道他的真正身份，所以可以装作自己是梅林来迷惑派西维尔。";
                break;
            case "刺客":
                this.imageId = R.drawable.cike;
                this.content = "坏人方的精英，他能被梅林看见，他的任务是寻找真正的梅林，并在好人赢得三局游戏后刺杀梅林，刺杀成功则坏人胜利。";
                break;
            case "奥伯伦":
                this.imageId = R.drawable.aobolun;
                this.content = "坏人方角色，但是他看不到他的队友，他的队友也看不到他，他能被梅林看见。";
                break;
            case "黑老大":
                this.imageId = R.drawable.heilaoda;
                this.content = "在忠臣里的坏人，梅林晚上看不到他，所以他隐藏在平民里，混进队伍让任务失败。";
                break;
            case "爪牙":
                this.imageId = R.drawable.zhuaya;
                this.content = "坏人方角色，能被梅林看到。";
                break;
            default:
                break;
        }
    }

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

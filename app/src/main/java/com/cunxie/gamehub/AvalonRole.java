package com.cunxie.gamehub;

public class AvalonRole {
    private String name;
    private int imageId;
    private String detail;

    public AvalonRole(String name, int imageId, String detail) {
        this.name = name;
        this.imageId = imageId;
        this.detail = detail;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }

    public String getDetail() {
        return this.detail;
    }
}

package com.example.falltilldie_10.Setting;

public class BackgroundSetting {
    String nameBackground;
    int linkImg;

    public BackgroundSetting(String nameBackground, int linkImg) {
        this.nameBackground = nameBackground;
        this.linkImg = linkImg;
    }

    public String getNameBackground() {
        return nameBackground;
    }

    public void setNameBackground(String nameBackground) {
        this.nameBackground = nameBackground;
    }

    public int getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(int linkImg) {
        this.linkImg = linkImg;
    }
}

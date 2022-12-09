package com.example.falltilldie_10.Setting;

public class CharacterSetting {
    String name;
    int linkImg;

    public CharacterSetting(String name, int linkImg) {
        this.name = name;
        this.linkImg = linkImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(int linkImg) {
        this.linkImg = linkImg;
    }
}

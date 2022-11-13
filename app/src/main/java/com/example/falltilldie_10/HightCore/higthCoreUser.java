package com.example.falltilldie_10.HightCore;

public class higthCoreUser {

    private int srcID;
    private String name;
    private int point;
    private int rank;

    public higthCoreUser(int srcID, String name, int point, int rank) {
        this.srcID = srcID;
        this.name = name;
        this.point = point;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public int getSrcID() {
        return srcID;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSrcID(int srcID) {
        this.srcID = srcID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

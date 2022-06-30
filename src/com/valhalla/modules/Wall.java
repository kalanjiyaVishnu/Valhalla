package com.valhalla.modules;

public class Wall {

    int height;
    boolean isDamaged = false;
    char location;
    int prevDamage;

    public Wall(int height, char location) {
        this.height = height;
        this.location = location;
    }

    boolean canWithStand(int impactHeight) {
        prevDamage = impactHeight;
        return impactHeight < height;
    }


    public void rebuildStrong() {

        this.height = prevDamage + 1;
        prevDamage = 0;
    }

    public int getPrevDamage() {
        return prevDamage;
    }

    public void setPrevDamage(int prevDamage) {
        this.prevDamage = prevDamage;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                ", location=" + location +
                '}';
    }
}

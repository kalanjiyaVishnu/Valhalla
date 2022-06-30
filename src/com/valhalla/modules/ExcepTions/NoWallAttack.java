package com.valhalla.modules.ExcepTions;

public class NoWallAttack extends Exception {
    public NoWallAttack(){
        super("CLAN HAS NO WALL ON THIS DIRECTION!! :) EASY WIN");
    }
}

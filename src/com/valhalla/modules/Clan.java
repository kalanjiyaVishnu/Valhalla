package com.valhalla.modules;

import com.valhalla.modules.ExcepTions.NoWallAttack;
import com.valhalla.utils.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Clan {
    Tribe tribe;
    Map<Character, Wall> walls = new HashMap<>();
    int BATTLE_WON;

    int BATTLE_LOST;

    public Clan(Tribe tribe) {
        this.tribe = tribe;
        buildWalls();
    }

    private void buildWalls() {
//        totalWAll: int to generate n number of walls rather than four -> list<Direction> -> map and gen walls
        /*

        for (var dir :
                Direction.values()) {
            walls.put(dir.toString().charAt(0), new Wall(0, 'N'));
        }
        */
//       but for now hard coding
        Stream.of('N', 'S', 'W', 'E').forEach(d -> walls.put(d, new Wall(0, d)));
    }

    public boolean defend(Tribe attackingTribe, char directionOfAttack) {
        try {
            if (!walls.containsKey(directionOfAttack)) {
                throw new NoWallAttack();
//            throw new IllegalStateException("CLAN HAS NO WALL ON THIS DIRECTION!! :) EASY WIN");
            }
        } catch (NoWallAttack e) {
            throw new RuntimeException(e);
        }

        System.out.println(attackingTribe + " attacking in " + directionOfAttack);

//        classic State pattern
        if (!isWallCanWithstandInDirection(directionOfAttack, attackingTribe.attackingWeapon.attackImpact)) {
            walls.get(directionOfAttack).rebuildStrong();
            currBattleStatus(false);
            return false;
        }

        System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
        currBattleStatus(true);
        return true;

    }

    boolean isWallCanWithstandInDirection(char dir, int attackImpact) {
        return walls.get(dir).canWithStand(attackImpact);
    }

    public void clanStatus() {
        System.out.println("-----------");
        System.out.println(this.clanName() + " has Lost to " + this.BATTLE_LOST + " tribes");
        System.out.println("-----------");
    }

    private void currBattleStatus(boolean isWon){
        if (isWon) {
            BATTLE_WON++;
        }
        else BATTLE_LOST++;
    }

    public String clanName() {
        return tribe.name;
    }
    public int battlesLost() {
        return BATTLE_LOST;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "clanName='" + tribe.name + '\'' +
                ", walls status ='" + walls +
                '}';
    }
}

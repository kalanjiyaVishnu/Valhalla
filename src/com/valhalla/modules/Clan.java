package com.valhalla.modules;

import java.util.HashMap;
import java.util.Map;

public class Clan {
    Tribe tribe;
    Map<Character, Wall> walls = new HashMap<>();
    public int BATTLE_WON;
    public int BATTLE_LOST;

    public Clan(Tribe tribe) {
        this.tribe = tribe;
        buildWalls();
    }

    private void buildWalls() {
//        totalWAll: int to generate n number of walls rather than four -> list<Direction> -> map and gen walls
//       but for now hard coding
        walls.put('N', new Wall(0, 'N'));
        walls.put('S', new Wall(0, 'S'));
        walls.put('W', new Wall(0, 'W'));
        walls.put('E', new Wall(0, 'E'));
    }

    @Override
    public String toString() {
        return "Clan{" +
                "clanName='" + tribe.name + '\'' +
                ", walls status ='" + walls +
                '}';
    }

//    public boolean attack(Clan clan,Weapon weapon) {
//        clan.battle(
//    }


    public boolean defend(Tribe attackingTribe, char directionOfAttack) {
        System.out.println(attackingTribe + " attacking in " + directionOfAttack);
//        classic State pattern
        if (!walls.get(directionOfAttack).canWithStand(attackingTribe.attackingWeapon.attackImpact)) {

            walls.get(directionOfAttack).rebuildStrong();
            currBattleStatus(false);
            return false;
        } else {
            System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
            currBattleStatus(true);
            return true;
        }

       /*
        switch (directionOfAttack) {

            case "N":
//                System.out.println(attackingTribe);
                if (!walls.get(directionOfAttack).canWithStand(attackingTribe.attackingWeapon.attackImpact)) {
                    walls.get(directionOfAttack).rebuildStrong();
                } else {
                    System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
                }
                break;
            case "S":
                if (!walls.get(directionOfAttack).canWithStand(attackingTribe.weaponMap.get("X").attackImpact)) {
                    walls.get(directionOfAttack).rebuildStrong();
                } else {
                    System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
                }
                break;
            case "W":
//                if (!walls.get(directionOfAttack).canWithStand(attackingTribe.weaponMap.get("X").attackImpact)) {
//                    walls.get(directionOfAttack).rebuildStrong();
//                } else {
//                    System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
//                }
                break;
            case "E":
//                if (!walls.get(directionOfAttack).canWithStand(attackingTribe.weaponMap.get("X").attackImpact)) {
//                    walls.get(directionOfAttack).rebuildStrong();
//                } else {
//                    System.out.println(this.tribe.name + " WON against " + attackingTribe.name);
//                }
                break;

        }
        */
    }

    public void clanStatus() {
        System.out.println("-----------");
        System.out.println(this.clanName() + " has Lost to " + this.BATTLE_LOST + " tribes");
        System.out.println("-----------");
    }
    void currBattleStatus(boolean isWon){
        if (isWon) {
            BATTLE_WON++;
        }
        else BATTLE_LOST++;
    }

    public String clanName() {
        return tribe.name;
    }
}

package com.valhalla;

import com.valhalla.modules.Clan;
import com.valhalla.modules.Tribe;
import com.valhalla.utils.Utils;

import java.util.Scanner;

public class BattleField {
    public Clan defendingClan;
    public BattleField(Clan defendingClan) {
        this.defendingClan = defendingClan;
    }

    public static void main(String[] args) {
        var bersekers = new Clan(new Tribe("Bersekers"));
        String query = "Day 1$ T1 - S - X - 4: T1 - N - X - 2: T3 - W - X - 3; Day 2$ T2 - S - X - 5: T2- N - X - 1: T3 - N - X - 3; Day 3$ T1 - W - X - 2: T1 - W - X - 4: T2 - N - X - 3: T2- S - X - 4";
        new BattleField(bersekers).startWar(query);
    }

    public void startWar(String query) {
//        Scanner sc = new Scanner(System.in);
        query = Utils.removeSpace(query);
        try {
            String[] dayWiseAttacks = query.split(";");

            for (String warDay:
                    dayWiseAttacks) {
                String[] q = warDay.split("\\$");

                String day = q[0];
                System.out.println(day + " Attacks");

                String[] attackingForcesOnThisDay = q[1].split(":");
                currIncomminTribes(attackingForcesOnThisDay);

            }
//            Battle status
            defendingClan.clanStatus();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //    total tribe attacks in a day
    public void currIncomminTribes(String[] tribes) {
        for (String force :
                tribes) {
            String[] tribeDetails = force.split("-");
            String tribeName = tribeDetails[0];
            char dirOfAttack = tribeDetails[1].toCharArray()[0];
            var tribe = new Tribe(tribeName);
            tribe.addWeapon(tribeDetails[2], Integer.parseInt(tribeDetails[3]));
            defendingClan.defend(tribe, dirOfAttack);
        }
    }
}

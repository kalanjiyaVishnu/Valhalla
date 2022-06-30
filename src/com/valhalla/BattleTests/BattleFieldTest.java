package com.valhalla.BattleTests;

import com.valhalla.BattleField;
import com.valhalla.modules.Clan;
import com.valhalla.modules.Tribe;

import static org.junit.jupiter.api.Assertions.*;

class BattleFieldTest {

    @org.junit.jupiter.api.Test
    void testSingleAttack() {
        String query = "Day 1$ T1 - N - X - 3; Day 2$ T1 - N - X - 4";
//        create a defending clan
        var bersekers = new Clan(new Tribe("Bersekers"));
//        start the war
        new BattleField(bersekers).startWar(query.replaceAll("\\s+", ""));
        assertEquals(2, bersekers.battlesLost());
    }

    @org.junit.jupiter.api.Test
    void testThreeDayWar(){
        String q = "Day 1$ T1 - S - X - 4: T1 - N - X - 2: T3 - W - X - 3; Day 2$ T2 - S - X - 5: T2- N - X - 1: T3 - N - X - 3; Day 3$ T1 - W - X - 2: T1 - W - X - 4: T2 - N - X - 3: T2- S - X - 4";
//        create a defending clan
        var bersekers = new Clan(new Tribe("Bersekers"));
//        start the war
        new BattleField(bersekers).startWar(q.replaceAll("\\s+", ""));
        assertEquals(6, bersekers.battlesLost());
    }
}
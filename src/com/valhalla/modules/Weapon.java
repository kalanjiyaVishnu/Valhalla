package com.valhalla.modules;

public class Weapon {
    String name;
    int attackImpact;

    public Weapon(String name, int impact) {
        this.name = name;
        attackImpact = impact;
    }

    public void weaponUpgrage(int xp) {
        this.attackImpact += xp;
    }

    @Override
    public String toString() {
        return "{ " + name + '\'' +
                ", attackImpact=" + attackImpact +
                '}';
    }

}

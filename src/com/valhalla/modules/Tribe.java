package com.valhalla.modules;
public class Tribe {
    String name;
    //    Map<String, Weapon> weaponMap = new HashMap<>();
    Weapon attackingWeapon;
    public Tribe(String name) {
        this.name = name;
    }

    public void addWeapon(String weaponName, int impact) {
//        weaponMap.put(weaponName, new Weapon(weaponName, impact));
        attackingWeapon = new Weapon(weaponName, impact);
    }

    @Override
    public String toString() {
        return "Tribe - " + name + '\'' +
                ", attackingWeapon=" + attackingWeapon;
    }
}

package com.narxoz.rpg.combat;

public class Resurrection implements Ability {

    @Override
    public String getName() {
        return "Resurrection";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Revives after death with partial health.";
    }

    @Override
    public Ability clone() {
        return new Resurrection();
    }
}

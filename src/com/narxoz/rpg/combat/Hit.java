package com.narxoz.rpg.combat;

public class Hit implements Ability {

    @Override
    public String getName() {
        return "Hit";
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Basic physical attack.";
    }

    @Override
    public Ability clone() {
        return new Hit();
    }
}

package com.narxoz.rpg.combat;

public class Luck implements Ability {

    @Override
    public String getName() {
        return "Luck";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Temporarily increases critical chance.";
    }

    @Override
    public Ability clone() {
        return new Luck();
    }
}

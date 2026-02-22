package com.narxoz.rpg.combat;

public class Jerk implements Ability {

    @Override
    public String getName() {
        return "Jerk";
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Quick sudden strike with minor damage.";
    }

    @Override
    public Ability clone() {
        return new Jerk();
    }
}

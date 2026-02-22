package com.narxoz.rpg.combat;

public class Slowdown implements Ability {

    @Override
    public String getName() {
        return "Slowdown";
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Reduces enemy speed temporarily.";
    }

    @Override
    public Ability clone() {
        return new Slowdown();
    }
}

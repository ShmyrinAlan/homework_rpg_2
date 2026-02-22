package com.narxoz.rpg.combat;

public class Heal implements Ability {

    @Override
    public String getName() {
        return "Heal";
    }

    @Override
    public int getDamage() {
        return -30;
    }

    @Override
    public String getDescription() {
        return "Restores health instead of dealing damage.";
    }

    @Override
    public Ability clone() {
        return new Heal();
    }
}

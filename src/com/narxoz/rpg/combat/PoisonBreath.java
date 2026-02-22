package com.narxoz.rpg.combat;

public class PoisonBreath implements Ability {

    @Override
    public String getName() {
        return "Poison Breath";
    }

    @Override
    public int getDamage() {
        return 30;
    }

    @Override
    public String getDescription() {
        return "Releases toxic fumes causing poison damage over time.";
    }

    @Override
    public Ability clone() {
        return new PoisonBreath();
    }
}

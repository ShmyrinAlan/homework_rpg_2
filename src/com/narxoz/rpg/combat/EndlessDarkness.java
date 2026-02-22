package com.narxoz.rpg.combat;

public class EndlessDarkness implements Ability {

    @Override
    public String getName() {
        return "Endless Darkness";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Engulfs the battlefield in darkness dealing shadow damage.";
    }

    @Override
    public Ability clone() {
        return new EndlessDarkness();
    }
}

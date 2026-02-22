package com.narxoz.rpg.combat;

public class ShadowBreath implements Ability {

    @Override
    public String getName() {
        return "Shadow Breath";
    }

    @Override
    public int getDamage() {
        return 45;
    }

    @Override
    public String getDescription() {
        return "Unleashes dark energy damaging all enemies ahead.";
    }

    @Override
    public Ability clone() {
        return new ShadowBreath();
    }
}

package com.narxoz.rpg.combat;

public class Spit implements Ability {

    @Override
    public String getName() {
        return "Spit";
    }

    @Override
    public int getDamage() {
        return 12;
    }

    @Override
    public String getDescription() {
        return "Spits acidic projectile at the target.";
    }

    @Override
    public Ability clone() {
        return new Spit();
    }
}

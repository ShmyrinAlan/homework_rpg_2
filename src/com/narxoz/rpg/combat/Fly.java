package com.narxoz.rpg.combat;

public class Fly implements Ability {

    @Override
    public String getName() {
        return "Fly";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Takes flight, avoiding ground attacks.";
    }

    @Override
    public Ability clone() {
        return new Fly();
    }
}

package com.narxoz.rpg.combat;

public class Acceleration implements Ability {

    public Acceleration(){}

    @Override
    public String getName() {
        return "Acceleration";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Increases speed significantly for a short duration.";
    }

    @Override
    public Ability clone() {
        return new Acceleration();
    }
}

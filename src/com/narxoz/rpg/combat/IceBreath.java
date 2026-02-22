package com.narxoz.rpg.combat;

public class IceBreath implements Ability {

    @Override
    public String getName() {
        return "Ice Breath";
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public String getDescription() {
        return "Breathes freezing air that slows enemies.";
    }

    @Override
    public Ability clone() {
        return new IceBreath();
    }
}

package com.narxoz.rpg.combat;

public class FireBreath implements Ability {

    @Override
    public String getName() {
        return "Fire Breath";
    }

    @Override
    public int getDamage() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Unleashes a cone of fire dealing heavy burn damage.";
    }

    @Override
    public Ability clone() {
        return new FireBreath();
    }
}

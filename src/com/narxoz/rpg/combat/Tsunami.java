package com.narxoz.rpg.combat;

public class Tsunami implements Ability {

    @Override
    public String getName() {
        return "Tsunami";
    }

    @Override
    public int getDamage() {
        return 55;
    }

    @Override
    public String getDescription() {
        return "Summons a massive wave dealing heavy water damage.";
    }

    @Override
    public Ability clone() {
        return new Tsunami();
    }
}

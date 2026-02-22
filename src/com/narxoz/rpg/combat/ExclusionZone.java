package com.narxoz.rpg.combat;

public class ExclusionZone implements Ability {

    @Override
    public String getName() {
        return "Exclusion Zone";
    }

    @Override
    public int getDamage() {
        return 25;
    }

    @Override
    public String getDescription() {
        return "Creates a damaging area enemies cannot escape.";
    }

    @Override
    public Ability clone() {
        return new ExclusionZone();
    }
}

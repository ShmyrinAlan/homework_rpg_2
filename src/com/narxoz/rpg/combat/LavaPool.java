package com.narxoz.rpg.combat;

public class LavaPool implements Ability {

    @Override
    public String getName() {
        return "Lava Pool";
    }

    @Override
    public int getDamage() {
        return 45;
    }

    @Override
    public String getDescription() {
        return "Creates a burning lava area under enemies.";
    }

    @Override
    public Ability clone() {
        return new LavaPool();
    }
}

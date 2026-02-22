package com.narxoz.rpg.enemy;

import java.util.HashMap;

public class Demon extends AbstractEnemy {

    private int corruptionLevel;
    private boolean summonMinions;

    private Demon(Builder builder) {
        super(builder);
        this.corruptionLevel = builder.corruptionLevel;
        this.summonMinions = builder.summonMinions;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Demon) ===");
        displayBaseInfo();
        System.out.println("Corruption: " + corruptionLevel +
                " Summons: " + summonMinions);
    }

    @Override
    public Enemy clone() {
        return new Builder()
                .name(name).health(health).damage(damage)
                .defense(defense).speed(speed)
                .abilities(getAbilities())
                .phases(new HashMap<>(phases))
                .lootTable(lootTable)
                .corruptionLevel(corruptionLevel)
                .summonMinions(summonMinions)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder<Builder> {

        private int corruptionLevel;
        private boolean summonMinions;

        public Builder corruptionLevel(int val){ corruptionLevel = val; return this; }
        public Builder summonMinions(boolean val){ summonMinions = val; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Demon build(){
            if (name == null || health <= 0) {
                throw new IllegalStateException("Enemy must have name and health!");
            }
            return new Demon(this);
        }
    }
}
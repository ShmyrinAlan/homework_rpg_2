package com.narxoz.rpg.enemy;

import java.util.HashMap;

public class Murloc extends AbstractEnemy {

    private boolean aquatic;
    private int swarmBonus;

    private Murloc(Builder builder) {
        super(builder);
        this.aquatic = builder.aquatic;
        this.swarmBonus = builder.swarmBonus;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Murloc) ===");
        displayBaseInfo();
        System.out.println("Aquatic: " + aquatic +
                " Swarm Bonus: " + swarmBonus);
    }

    @Override
    public Enemy clone() {
        return new Builder()
                .name(name).health(health).damage(damage)
                .defense(defense).speed(speed)
                .abilities(getAbilities())
                .phases(new HashMap<>(phases))
                .lootTable(lootTable)
                .aquatic(aquatic)
                .swarmBonus(swarmBonus)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder<Builder> {

        private boolean aquatic;
        private int swarmBonus;

        public Builder aquatic(boolean val){ aquatic = val; return this; }
        public Builder swarmBonus(int val){ swarmBonus = val; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Murloc build(){
            if (name == null || health <= 0) {
                throw new IllegalStateException("Enemy must have name and health!");
            }
            return new Murloc(this);
        }
    }
}
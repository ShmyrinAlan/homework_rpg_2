package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.factory.ElfComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.HashMap;
import java.util.List;

public class Elf extends AbstractEnemy {

    private boolean archer;
    private int forestAffinity;

    private Elf(Builder builder) {
        super(builder);
        this.archer = builder.archer;
        this.forestAffinity = builder.forestAffinity;
        this.race = new ElfComponentFactory();
        this.aiBehavior = String.join(" ,", List.of(race.createAIBehavior(), element.createAIBehavior()));
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Elf) ===");
        displayBaseInfo();
        System.out.println("Archer: " + archer +
                " Forest Affinity: " + forestAffinity);
    }

    @Override
    public Enemy clone() {
        return new Builder()
                .name(name).health(health).damage(damage)
                .defense(defense).speed(speed)
                .element(element)
                .phases(new HashMap<>(phases))
                .archer(archer)
                .forestAffinity(forestAffinity)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder<Builder> {

        private boolean archer;
        private int forestAffinity;

        public Builder archer(boolean val){ archer = val; return this; }
        public Builder forestAffinity(int val){ forestAffinity = val; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Elf build(){
            if (name == null || health <= 0) {
                throw new IllegalStateException("Enemy must have name and health!");
            }
            return new Elf(this);
        }
    }
}
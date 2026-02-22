package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
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
                .abilities(getAbilities())
                .phases(new HashMap<>(phases))
                .lootTable(lootTable)
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
        @Override public Elf build(){ return new Elf(this); }
    }
}
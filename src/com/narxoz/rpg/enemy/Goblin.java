package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.factory.GoblinComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Example basic enemy implementation — a simple Goblin.
 *
 * This is provided as a REFERENCE to show enemy structure.
 * Study this implementation, then create more enemies.
 *
 * Notice:
 * - Simple stats (low health, low damage)
 * - Basic constructor (only a few parameters — no Builder needed!)
 * - This is intentionally simple to contrast with Dragon.java
 *
 * ============================================================
 * IMPORTANT OBSERVATION:
 * ============================================================
 *
 * A Goblin is simple: name, health, damage, defense — done.
 * A regular constructor works fine here:
 *     new Goblin("Forest Goblin")
 *
 * But look at Dragon.java... THAT'S where Builder shines!
 * Simple objects don't need Builder. Complex objects do.
 * Knowing WHEN to use a pattern is as important as knowing HOW.
 *
 * ============================================================
 * PROTOTYPE PATTERN NOTE:
 * ============================================================
 *
 * Goblin is a GREAT candidate for Prototype pattern!
 * Imagine you need 50 goblins for a dungeon. Instead of:
 *     new Goblin("Goblin 1"), new Goblin("Goblin 2"), ...
 *
 * You can:
 *     Goblin template = new Goblin("Goblin");
 *     Enemy goblin1 = template.clone();  // Fast!
 *     Enemy goblin2 = template.clone();  // Fast!
 *
 * And for variants:
 *     Enemy elite = template.clone();
 *     // modify elite's stats to 2x
 *
 * TODO: Implement the clone() method with DEEP COPY.
 * TODO: Create similar basic enemies: Skeleton, Orc, etc.
 * TODO: Consider what needs deep vs shallow copy here.
 *   - Primitive stats (health, damage) → shallow copy is fine
 *   - Ability list → MUST be deep copied!
 *   - LootTable → MUST be deep copied!
 */
public class Goblin extends AbstractEnemy {

    private boolean cowardly;
    private int stealChance;

    private Goblin(Builder builder) {
        super(builder);
        this.cowardly = builder.cowardly;
        this.stealChance = builder.stealChance;
        this.race = new GoblinComponentFactory();
        this.aiBehavior = String.join(" ,", List.of(race.createAIBehavior(), element.createAIBehavior()));
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        displayBaseInfo();
        System.out.println("Cowardly: " + cowardly +
                " Steal Chance: " + stealChance + "%");
    }

    @Override
    public Enemy clone() {
        return new Builder()
                .name(name).health(health).damage(damage)
                .defense(defense).speed(speed)
                .element(element)
                .phases(new HashMap<>(phases))
                .cowardly(cowardly)
                .stealChance(stealChance)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder<Builder> {

        private boolean cowardly;
        private int stealChance;

        public Builder cowardly(boolean val){ cowardly = val; return this; }
        public Builder stealChance(int val){ stealChance = val; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Goblin build(){
            if (name == null || health <= 0) {
                throw new IllegalStateException("Enemy must have name and health!");
            }
            return new Goblin(this);
        }
    }
}
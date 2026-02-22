package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Example complex boss enemy — THE REASON BUILDER PATTERN EXISTS.
 *
 * ============================================================
 * READ THIS CAREFULLY — THIS IS THE CORE LEARNING MOMENT!
 * ============================================================
 *
 * Look at this constructor. REALLY look at it.
 * Count the parameters. Imagine using it in Main.java.
 * Imagine a teammate trying to understand what each parameter means.
 *
 * This is called the "Telescoping Constructor" anti-pattern.
 * It's the #1 problem that the Builder pattern solves.
 *
 * YOUR MISSION:
 * After studying this horror, you will create an EnemyBuilder
 * that constructs DragonBoss (and other complex enemies)
 * step-by-step, with clear and readable code.
 *
 * Compare:
 *
 *   BEFORE (Telescoping Constructor — current code):
 *   new DragonBoss("Fire Dragon", 50000, 500, 200, 50, "FIRE",
 *       abilities, 30000, 15000, 5000, loot, "AGGRESSIVE",
 *       true, true, 20);
 *   // What does 'true, true, 20' mean? Nobody knows!
 *
 *   AFTER (Builder Pattern — your implementation):
 *   new BossEnemyBuilder()
 *       .setName("Fire Dragon")
 *       .setHealth(50000)
 *       .setDamage(500)
 *       .setDefense(200)
 *       .setSpeed(50)
 *       .setElement("FIRE")
 *       .addAbility(new FlameBreath())
 *       .addAbility(new WingBuffet())
 *       .addPhase(1, 50000)
 *       .addPhase(2, 30000)
 *       .addPhase(3, 15000)
 *       .setLootTable(fireLoot)
 *       .setAI("AGGRESSIVE")
 *       .build();
 *   // Every parameter is labeled! Readable! Maintainable!
 *
 * ============================================================
 * TODO: After implementing your Builder, REFACTOR this class!
 * ============================================================
 * - Remove (or simplify) the telescoping constructor
 * - Make DragonBoss constructable ONLY through a Builder
 * - Make the built DragonBoss IMMUTABLE (no setters!)
 * - The Builder handles all the complexity
 */
public class Dragon extends AbstractEnemy {

    private String element;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    private Dragon(Builder builder) {
        super(builder);
        this.element = builder.element;
        this.canFly = builder.canFly;
        this.hasBreathAttack = builder.hasBreathAttack;
        this.wingspan = builder.wingspan;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon) ===");
        displayBaseInfo();
        System.out.println("Element: " + element);
        System.out.println("Fly: " + canFly +
                " Breath: " + hasBreathAttack +
                " Wingspan: " + wingspan);
    }

    @Override
    public Enemy clone() {
        return new Builder()
                .name(name).health(health).damage(damage)
                .defense(defense).speed(speed)
                .abilities(getAbilities())
                .phases(new HashMap<>(phases))
                .lootTable(lootTable)
                .element(element)
                .canFly(canFly)
                .hasBreathAttack(hasBreathAttack)
                .wingspan(wingspan)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder<Builder> {

        private String element;
        private boolean canFly;
        private boolean hasBreathAttack;
        private int wingspan;

        public Builder element(String val){ element = val; return this; }
        public Builder canFly(boolean val){ canFly = val; return this; }
        public Builder hasBreathAttack(boolean val){ hasBreathAttack = val; return this; }
        public Builder wingspan(int val){ wingspan = val; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Dragon build(){
            if (name == null || health <= 0) {
                throw new IllegalStateException("Enemy must have name and health!");
            }
            return new Dragon(this);
        }
    }
}
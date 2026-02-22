package com.narxoz.rpg.enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public abstract class AbstractEnemy implements Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;

    protected List<Ability> abilities;
    protected Map<Integer,Integer> phases;
    protected LootTable lootTable;

    protected AbstractEnemy(BaseBuilder<?> builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
        this.defense = builder.defense;
        this.speed = builder.speed;
        this.abilities = new ArrayList<>(builder.abilities);
        this.phases = builder.phases != null
                ? new HashMap<>(builder.phases)
                : new HashMap<>();
        this.lootTable = builder.lootTable;
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    protected void displayBaseInfo() {

        System.out.println("HP: " + health +
                " DMG: " + damage +
                " DEF: " + defense +
                " SPD: " + speed);

        if (!abilities.isEmpty()) {
            System.out.println("Abilities:");
            for (Ability a : abilities) {
                System.out.println(" - " + a.getDescription());
            }
        }

        if (!phases.isEmpty()) {
            System.out.println("Phases:");
            for (var e : phases.entrySet()) {
                System.out.println(" Phase " + e.getKey()
                        + " at " + e.getValue() + " HP");
            }
        }

        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    public abstract Enemy clone();

    // ===== GENERIC BUILDER BASE =====

    public abstract static class BaseBuilder<T extends BaseBuilder<T>> {

        private String name;
        private int health;
        private int damage;
        private int defense;
        private int speed;

        private List<Ability> abilities = new ArrayList<>();
        private Map<Integer,Integer> phases = new HashMap<>();
        private LootTable lootTable;

        public T name(String val){ name = val; return self(); }
        public T health(int val){ health = val; return self(); }
        public T damage(int val){ damage = val; return self(); }
        public T defense(int val){ defense = val; return self(); }
        public T speed(int val){ speed = val; return self(); }
        public T abilities(List<Ability> val){ abilities = val; return self(); }
        public T phases(Map<Integer,Integer> val){ phases = val; return self(); }
        public T lootTable(LootTable val){ lootTable = val; return self(); }

        protected abstract T self();
        public abstract AbstractEnemy build();
    }
}

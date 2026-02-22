package com.narxoz.rpg.enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.loot.BasicLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractEnemy implements Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String aiBehavior;

    protected EnemyComponentFactory race;
    protected EnemyComponentFactory element;

    protected Map<Integer,Integer> phases;

    protected AbstractEnemy(BaseBuilder<?> builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
        this.defense = builder.defense;
        this.speed = builder.speed;
        this.element = builder.element;
        this.phases = builder.phases != null
                ? new HashMap<>(builder.phases)
                : new HashMap<>();
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }

    @Override
    public List<Ability> getAbilities() {
        List<Ability> response = race.createAbilities();
        response.addAll(element.createAbilities());
        return response;
    }

    @Override
    public LootTable getLootTable() {
        LootTable response = race.createLootTable(new BasicLootTable());
        response = element.createLootTable(response);
        return response;
    }

    protected void displayBaseInfo() {

        System.out.println("HP: " + health +
                " DMG: " + damage +
                " DEF: " + defense +
                " SPD: " + speed +
                " AI: " + aiBehavior);

        List<Ability> abilities = race.createAbilities();
        abilities.addAll(element.createAbilities());
        System.out.println("Abilities:");
        for (Ability a : abilities) {
            System.out.println(" - "+ a.getName()+" (" + a.getDescription()+")");
        }


        if (!phases.isEmpty()) {
            System.out.println("Phases:");
            for (var e : phases.entrySet()) {
                System.out.println(" Phase " + e.getKey()
                        + " at " + e.getValue() + " HP");
            }
        }


        System.out.println("Loot: " + getLootTable().getLootInfo());

    }

    public abstract Enemy clone();

    // ===== GENERIC BUILDER BASE =====

    public abstract static class BaseBuilder<T extends BaseBuilder<T>> {

        protected String name;
        protected int health;
        protected int damage;
        protected int defense;
        protected int speed;

        protected EnemyComponentFactory element = new DefaultComponentFactory();
        private Map<Integer,Integer> phases = new HashMap<>();

        public T name(String val){ name = val; return self(); }
        public T health(int val){ health = val; return self(); }
        public T damage(int val){ damage = val; return self(); }
        public T defense(int val){ defense = val; return self(); }
        public T speed(int val){ speed = val; return self(); }
        public T element(EnemyComponentFactory val){
            if(val.getClass().equals(FireComponentFactory.class) ||
                    val.getClass().equals(WaterComponentFactory.class) ||
                    val.getClass().equals(ShadowComponentFactory.class) ||
                    val.getClass().equals(PoisonComponentFactory.class))
                element = val;
            return self();
        }
        public T phases(Map<Integer,Integer> val){ phases = val; return self(); }
        public T addPhase(Integer number, Integer health){ phases.put(number, health); return self();}

        protected abstract T self();
        public abstract AbstractEnemy build();
    }
}

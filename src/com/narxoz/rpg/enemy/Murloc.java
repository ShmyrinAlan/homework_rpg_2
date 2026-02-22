package com.narxoz.rpg.enemy;

import com.narxoz.rpg.factory.MurlocComponentFactory;

import java.util.HashMap;
import java.util.List;

public class Murloc extends AbstractEnemy {

    private boolean aquatic;
    private int swarmBonus;

    private Murloc(Builder builder) {
        super(builder);
        this.aquatic = builder.aquatic;
        this.swarmBonus = builder.swarmBonus;
        this.race = new MurlocComponentFactory();
        this.aiBehavior = String.join(" ,", List.of(race.createAIBehavior(), element.createAIBehavior()));
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
                .element(element)
                .phases(new HashMap<>(phases))
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
package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class PoisonLootDecorator extends LootDecorator {

    public PoisonLootDecorator(LootTable loot) {
        super(loot);
    }

    @Override
    public String getLootInfo() {
        return String.format("""
                
                gold: %d
                exp: %d
                items: %s
                """, this.getGoldDrop(), this.getExperienceDrop(), String.join(", ", this.getItems()));
    }

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>(loot.getItems());
        items.add("Poison Flask");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 12;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 20;
    }

    @Override
    public LootTable clone() {
        return new PoisonLootDecorator(loot.clone());
    }
}


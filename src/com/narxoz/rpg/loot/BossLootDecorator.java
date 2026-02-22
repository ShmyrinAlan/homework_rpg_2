package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class BossLootDecorator extends LootDecorator {

    public BossLootDecorator(LootTable loot) {
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
        items.add("Boss Trophy");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 50;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 100;
    }

    @Override
    public LootTable clone() {
        return new BossLootDecorator(loot.clone());
    }
}


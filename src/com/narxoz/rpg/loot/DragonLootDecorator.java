package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class DragonLootDecorator extends LootDecorator {

    public DragonLootDecorator(LootTable loot) {
        super(loot);
    }

    @Override
    public String getLootInfo() {
        return String.format("""
                ====== LOOT ======
                gold: %d
                exp: %d
                items: %s
                """, this.getGoldDrop(), this.getExperienceDrop(), String.join(", ", this.getItems()));
    }

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>(loot.getItems());
        items.add("Dragon Scale");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 100;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 200;
    }

    @Override
    public LootTable clone() {
        return new DragonLootDecorator(loot.clone());
    }
}


package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class DemonLootDecorator extends LootDecorator {

    public DemonLootDecorator(LootTable loot) {
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
        items.add("Demon Horn");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 20;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 40;
    }

    @Override
    public LootTable clone() {
        return new DemonLootDecorator(loot.clone());
    }
}


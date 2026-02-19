package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootDecorator extends LootDecorator {

    public ShadowLootDecorator(LootTable loot) {
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
        items.add("Shadow Cloak");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 18;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 35;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootDecorator(loot.clone());
    }
}


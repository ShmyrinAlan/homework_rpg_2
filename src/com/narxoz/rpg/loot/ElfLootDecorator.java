package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ElfLootDecorator extends LootDecorator {

    public ElfLootDecorator(LootTable loot) {
        super(loot);

    }

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>(loot.getItems());
        items.add("Elven Bow");
        return items;
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
    public int getGoldDrop() {
        return loot.getGoldDrop() + 10;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 25;
    }

    @Override
    public LootTable clone() {
        return new ElfLootDecorator(loot.clone());
    }
}


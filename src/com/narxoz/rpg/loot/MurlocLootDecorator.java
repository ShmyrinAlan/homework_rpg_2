package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class MurlocLootDecorator extends LootDecorator {

    public MurlocLootDecorator(LootTable loot) {
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
        items.add("Murloc Fin");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop() + 8;
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop() + 15;
    }

    @Override
    public LootTable clone() {
        return new MurlocLootDecorator(loot.clone());
    }
}


package com.narxoz.rpg.loot;

import java.util.List;

public class BasicLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return List.of();
    }

    @Override
    public int getGoldDrop() {
        return 0;
    }

    @Override
    public int getExperienceDrop() {
        return 0;
    }

    @Override
    public String getLootInfo() {
        return "";
    }

    @Override
    public LootTable clone() {
        return null;
    }
}

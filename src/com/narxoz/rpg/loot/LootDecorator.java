package com.narxoz.rpg.loot;

import java.util.List;

public abstract class LootDecorator implements LootTable {

    protected final LootTable loot;

    protected LootDecorator(LootTable loot) {
        this.loot = loot;
    }

    @Override
    public List<String> getItems() {
        return loot.getItems();
    }

    @Override
    public int getGoldDrop() {
        return loot.getGoldDrop();
    }

    @Override
    public int getExperienceDrop() {
        return loot.getExperienceDrop();
    }

    @Override
    public String getLootInfo() {
        return loot.getLootInfo();
    }

    @Override
    public LootTable clone(){
        return null;
    }

}

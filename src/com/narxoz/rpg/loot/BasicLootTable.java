package com.narxoz.rpg.loot;

import java.util.List;
import java.util.Random;

public class BasicLootTable implements LootTable {
    protected List<String> items;
    protected int goldDrop;
    protected int experienceDrop;

    public BasicLootTable(){
        Random rn = new Random();
        this.items = List.of("Medallion");
        this.goldDrop = rn.nextInt(1,5);
        this.experienceDrop = rn.nextInt(1,10);
    }

    public BasicLootTable(List<String> items, int goldDrop, int experienceDrop) {
        this.items = items;
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
    }

    private BasicLootTable(BasicLootTable origin){
        this.items = List.copyOf(origin.items);
        this.goldDrop = origin.goldDrop;
        this.experienceDrop = origin.experienceDrop;
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
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
    public LootTable clone() {
        return new BasicLootTable(this);
    }

    protected void setItems(List<String> items) {
        this.items = items;
    }

    protected void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    protected void setExperienceDrop(int experienceDrop) {
        this.experienceDrop = experienceDrop;
    }
}

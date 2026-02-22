package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class DefaultComponentFactory implements EnemyComponentFactory{
    @Override
    public List<Ability> createAbilities() {
        return new ArrayList<>();
    }

    @Override
    public LootTable createLootTable(LootTable loot) {
        return loot;
    }

    @Override
    public String createAIBehavior() {
        return "";
    }
}

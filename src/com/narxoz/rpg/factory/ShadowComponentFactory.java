package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory{
    @Override
    public List<Ability> createAbilities() {
        return List.of();
    }

    @Override
    public LootTable createLootTable() {
        return null;
    }

    @Override
    public String createAIBehavior() {
        return "";
    }
}

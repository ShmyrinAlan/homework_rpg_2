package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.MurlocLootDecorator;

import java.util.ArrayList;
import java.util.List;

public class MurlocComponentFactory implements EnemyComponentFactory{
    private static final List<String> ABILITIES = List.of("hit", "jerk", "spit");
    @Override
    public List<Ability> createAbilities() {
        return new ArrayList<>(ABILITIES.stream().map(AbilityFactory.instance()::create).toList());
    }

    @Override
    public LootTable createLootTable(LootTable loot) {
        return new MurlocLootDecorator(loot);
    }

    @Override
    public String createAIBehavior() {
        return "stupid";
    }
}

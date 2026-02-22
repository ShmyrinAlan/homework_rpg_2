package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.PoisonLootDecorator;

import java.util.ArrayList;
import java.util.List;

public class PoisonComponentFactory implements EnemyComponentFactory{
    private static final List<String> ABILITIES = List.of("poison breath", "exclusion zone");
    @Override
    public List<Ability> createAbilities() {
        return new ArrayList<>(ABILITIES.stream().map(AbilityFactory.instance()::create).toList());
    }

    @Override
    public LootTable createLootTable(LootTable loot) {
        return new PoisonLootDecorator(loot);
    }

    @Override
    public String createAIBehavior() {
        return "tricky";
    }
}

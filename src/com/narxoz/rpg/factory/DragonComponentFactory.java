package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.DragonLootDecorator;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class DragonComponentFactory implements EnemyComponentFactory{
    private static final List<String> ABILITIES = List.of("hit", "Fly", "Jerk");
    @Override
    public List<Ability> createAbilities() {
        return new ArrayList<>(ABILITIES.stream().map(AbilityFactory.instance()::create).toList());
    }

    @Override
    public LootTable createLootTable(LootTable loot) {
        return new DragonLootDecorator(loot);
    }

    @Override
    public String createAIBehavior() {
        return "treasure saver";
    }
}

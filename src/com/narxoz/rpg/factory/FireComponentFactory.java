package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.FireLootDecorator;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory{
    private static final List<String> ABILITIES = List.of("lava pool", "fire breath");
    @Override
    public List<Ability> createAbilities() {
        return new ArrayList<>(ABILITIES.stream().map(AbilityFactory.instance()::create).toList());
    }

    @Override
    public LootTable createLootTable(LootTable loot) {
        return new FireLootDecorator(loot);
    }

    @Override
    public String createAIBehavior() {
        return "aggressive";
    }
}

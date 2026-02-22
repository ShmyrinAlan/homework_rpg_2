package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

class AbilityFactory {
    private final Map<String, Supplier<Ability>> abilities;
    private static AbilityFactory INSTANCE;

    private AbilityFactory(){
        abilities = new HashMap<>();
        abilities.put("acceleration", Acceleration::new);
        abilities.put("endless darkness", EndlessDarkness::new);
        abilities.put("exclusion zone", ExclusionZone::new);
        abilities.put("fire breath", FireBreath::new);
        abilities.put("fly", Fly::new);
        abilities.put("heal", Heal::new);
        abilities.put("hit", Hit::new);
        abilities.put("ice breath", IceBreath::new);
        abilities.put("jerk", Jerk::new);
        abilities.put("lava pool", LavaPool::new);
        abilities.put("luck", Luck::new);
        abilities.put("poison breath", PoisonBreath::new);
        abilities.put("resurrection", Resurrection::new);
        abilities.put("shadow breath", ShadowBreath::new);
        abilities.put("slowdown", Slowdown::new);
        abilities.put("spit", Spit::new);
        abilities.put("tsunami", Tsunami::new);
    }

    public static AbilityFactory instance(){
        if(Objects.isNull(INSTANCE)) INSTANCE = new AbilityFactory();
        return INSTANCE;
    }

    public Ability create(String name){
        Supplier<Ability> response = abilities.get(name.toLowerCase());
        if(Objects.isNull(response)) throw new IllegalArgumentException();
        return response.get();
    }
}

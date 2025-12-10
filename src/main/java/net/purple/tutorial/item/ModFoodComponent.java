package net.purple.tutorial.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

//double shift to see all food components (search "food components")
public class ModFoodComponent {

    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200, 2), 0.15f).build();
}

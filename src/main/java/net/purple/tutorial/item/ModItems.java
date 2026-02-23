package net.purple.tutorial.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.item.custom.ChiselItem;
import net.purple.tutorial.item.custom.HammerItem;

public class ModItems {

    public static final Item Six = registerItem("six", new Item(new Item.Settings()));
    public static final Item Seven = registerItem("seven", new Item(new Item.Settings()));
    public static final Item Numberium = registerItem("numberium", new Item(new Item.Settings()));

    public static final Item Chisel = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item Cauliflower = registerItem("cauliflower", new Item(new Item.Settings()
            .food(ModFoodComponent.CAULIFLOWER)));

    public static final Item Starlight_Ashes = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item Numberium_Sword = registerItem("numberium_sword",
            new SwordItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, 3, -2.4f))));
public static final Item Numberium_Pickaxe = registerItem("numberium_pickaxe",
            new PickaxeItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, 1.0F, -2.8F))));
public static final Item Numberium_Shovel = registerItem("numberium_shovel",
            new ShovelItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, 1.5F, -3.0F))));
public static final Item Numberium_Axe = registerItem("numberium_axe",
            new AxeItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, 5.0F, -3.0F))));
public static final Item Numberium_Hoe = registerItem("numberium_hoe",
            new HoeItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, -3.0F, 0.0F))));
public static final Item Numberium_Hammer = registerItem("numberium_hammer",
            new HammerItem(ModToolsMaterials.NUMBERIUM, new Item.Settings()
                    .attributeModifiers(HammerItem.createAttributeModifiers(ModToolsMaterials.NUMBERIUM, 7.0F, -3.4F))));
        public static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void RegisterModItems () {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);


    }
}

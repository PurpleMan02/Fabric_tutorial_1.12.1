package net.purple.tutorial.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.item.custom.ChiselItem;

public class ModItems {

    public static final Item Six = registerItem("six", new Item(new Item.Settings()));
    public static final Item Seven = registerItem("seven", new Item(new Item.Settings()));

    public static final Item Chisel = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }


    public static void RegisterModItems () {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);


    }
}

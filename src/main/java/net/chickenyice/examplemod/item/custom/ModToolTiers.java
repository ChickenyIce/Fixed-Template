package net.chickenyice.examplemod.item.custom;

import net.chickenyice.examplemod.ExampleMod;
import net.chickenyice.examplemod.item.ModItems;
import net.chickenyice.examplemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public final static Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3000, 11f, 6f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(ExampleMod.MODID, "sapphire"), List.of(Tiers.NETHERITE), List.of());

    public final static Tier ALEXANDRITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3000, 11f, 6f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(ExampleMod.MODID, "alexandrite"), List.of(Tiers.NETHERITE), List.of());

}



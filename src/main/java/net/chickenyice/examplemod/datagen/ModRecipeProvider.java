package net.chickenyice.examplemod.datagen;

import net.chickenyice.examplemod.ExampleMod;
import net.chickenyice.examplemod.block.custom.ModBlocks;
import net.chickenyice.examplemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMETABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(),
            ModBlocks.END_STONE_SAPPHIRE_ORE.get());


        private static final List<ItemLike> ALEXANDRITE_SMETABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

        public ModRecipeProvider(PackOutput pOutput) {
            super(pOutput);
        }

        @Override
        protected void buildRecipes(RecipeOutput recipeOutput) {
            oreSmelting(recipeOutput, SAPPHIRE_SMETABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
            oreBlasting(recipeOutput, SAPPHIRE_SMETABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
            oreSmelting(recipeOutput, ALEXANDRITE_SMETABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
            oreBlasting(recipeOutput, ALEXANDRITE_SMETABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                    .pattern("SSS")
                    .pattern("SSS")
                    .pattern("SSS")
                    .define('S', ModItems.SAPPHIRE.get())
                    .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                    .save(recipeOutput);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                    .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                    .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                    .pattern("SSS")
                    .pattern("SSS")
                    .pattern("SSS")
                    .define('S', ModItems.ALEXANDRITE.get())
                    .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                    .save(recipeOutput);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                    .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                    .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .save(recipeOutput);


        }

        protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
            oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
            oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
            Iterator var9 = pIngredients.iterator();

            while (var9.hasNext()) {
                ItemLike itemlike = (ItemLike) var9.next();
                SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                        pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                        has(itemlike)).save(pRecipeOutput, ExampleMod.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
            }

        }
    }

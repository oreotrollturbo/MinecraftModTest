package net.oreotroll.tutorialmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    KEN_INGOT(5,2500,2f,22f,26,
            ()->Ingredient.ofItems(ModItems.KEN_INGOT));

    //Ocenia is at war with Eurasia Ocenia has ALWAYS been at war with Eurasia

    private final int miningLevel;
    private final int itemDurability;
    private final float attackDamage;
    private final float miningSpeed;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float attackDamage, float miningSpeed, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.attackDamage = attackDamage;
        this.miningSpeed = miningSpeed;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

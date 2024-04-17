package net.oreotroll.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.block.entity.ModBlockEntities;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.entity.custom.PorcupineEntity;
import net.oreotroll.tutorialmod.item.ModItemGroups;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.screen.ModScreenHandlers;
import net.oreotroll.tutorialmod.sound.ModSounds;
import net.oreotroll.tutorialmod.util.ModCustomTrades;
import net.oreotroll.tutorialmod.util.ModLootTableModifiers;
import net.oreotroll.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() { // this simply initialises ze mod

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.ModifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorupineAttributes());

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();



		FuelRegistry.INSTANCE.add(ModItems.VODKA,400);


	}
}
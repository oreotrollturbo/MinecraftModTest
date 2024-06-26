package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.oreotroll.tutorialmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture); //Item tags are a very niche thing
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) { //I had forgotten this exists ngl
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KEN_HELMET,ModItems.KEN_CHESTPLATE,ModItems.KEN_LEGGINGS,ModItems.KEN_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.JETPACK_HELLRIDE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.JETPACK_HELLRIDE_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.KEN_WAITING_FOR_LOVE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.KEN_WAITING_FOR_LOVE_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.CANT_GO_TO_HELL_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.CANT_GO_TO_HELL_MUSIC_DISC);
    }
}

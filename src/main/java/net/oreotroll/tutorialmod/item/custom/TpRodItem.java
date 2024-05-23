package net.oreotroll.tutorialmod.item.custom;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TpRodItem extends Item {
    public TpRodItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        double maxReach = 1000; //The farthest target the cameraEntity can detect
        float tickDelta = 1.0F; //Used for tracking animation progress; no tracking is 1.0F
        boolean includeFluids = false; //Whether to detect fluids as blocks
        MinecraftClient client = MinecraftClient.getInstance();

        assert client.cameraEntity != null;
        HitResult hit = client.cameraEntity.raycast(maxReach, tickDelta, includeFluids);

        switch(hit.getType()) {
            case MISS:
                //nothing near enough
                break;
            case BLOCK:

                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockPos = blockHit.getBlockPos();

                assert MinecraftClient.getInstance().player != null;

                user.teleport(blockPos.getX(), blockPos.getY() + 1.1, blockPos.getZ());

                user.getItemCooldownManager().set(this,35);
                MinecraftClient.getInstance().player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT,1f,1f);

                break;

            case ENTITY:
                break;
        }
        return TypedActionResult.success(user.getStackInHand(hand),world.isClient() );
    }
}

package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.sound.ModSounds;

import java.util.Set;
import java.util.logging.Level;

public class ARItem extends Item {
    public ARItem(Settings settings) {
        super(settings);
    }

    public boolean hasBullet(PlayerEntity playerEntity, ItemStack stack){

        if (stack.isOf(ModItems.BULLET)){
            playerEntity.getInventory().removeOne(stack);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getOffHandStack();

        if (!world.isClient) {

            if (itemStack.isOf(ModItems.BULLET)) {

                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
                bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 40.5F, 0.0F);
                world.spawnEntity(bulletProjectileEntity);
            }else {
                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_GUN_DRY_FIRE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            }

        }
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return super.use(world, user, hand);
    }


}

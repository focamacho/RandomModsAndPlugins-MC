package com.focamacho.idontlikebees.mixin;

import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeehiveTileEntity.class)
public class BeehiveTileEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tick(CallbackInfo ci) {
        BlockPos pos = ((TileEntity)(Object)this).getPos();
        World world = ((TileEntity)(Object)this).getWorld();

        if(world != null) {
            world.removeTileEntity(pos);
            world.removeBlock(pos, false);
        }
    }

}

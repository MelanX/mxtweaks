package de.melanx.mxtweaks;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {
        Vector3d motion = event.player.getMotion();
        if (Math.abs(motion.getX()) < 0.1 && Math.abs(motion.getZ()) < 0.1 && event.player instanceof ServerPlayerEntity) {
            if (event.player.world.canBlockSeeSky(new BlockPos(event.player.getPosition().getX(), 0, event.player.getPosition().getZ()))) {
                ((ServerPlayerEntity) event.player).connection.floatingTickCount = 0;
                ((ServerPlayerEntity) event.player).connection.vehicleFloatingTickCount = 0;
            }
        }
    }
}

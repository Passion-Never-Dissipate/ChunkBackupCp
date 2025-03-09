package CbCpServer.mixins.Server;

import CbCpServer.GetServerInfo;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class getPlayerRightClicks {
    @Shadow public ServerPlayerEntity player;

    @Inject(method = "onPlayerInteractBlock", at = @At("HEAD"), cancellable = true)
    private void onStartUsing(PlayerInteractBlockC2SPacket packet, CallbackInfo ci){


        if (GetServerInfo.isState() &
                player.getMainHandStack().toString().split(" ")[1].equals("feather")) {

            BlockPos bPos = packet.getBlockHitResult().getBlockPos();
            Logger LOGGER = LoggerFactory.getLogger("CbCp");

            LOGGER.info("RightClick {} {} {} {} {} {} {} {}",
                    player.getUuid(),
                    bPos.getX(), bPos.getY(), bPos.getZ(),
                    player.getWorld().getRegistryKey().getValue(),
                    player.getPos().getX(), player.getPos().getY(), player.getPos().getZ());

            String requestInfo = "坐标点2：" +
                    bPos.getX() + " " +
                    bPos.getY() + " " +
                    bPos.getZ() + " " +
                    "已记录";

            player.sendMessage(Text.literal(requestInfo));

            
            ci.cancel();
        }
    }
}

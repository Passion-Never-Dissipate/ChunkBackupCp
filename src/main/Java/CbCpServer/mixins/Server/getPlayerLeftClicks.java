package CbCpServer.mixins.Server;

import CbCpServer.GetServerInfo;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action.START_DESTROY_BLOCK;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class getPlayerLeftClicks {
    //onPlayerAction

    @Shadow
    public ServerPlayerEntity player;

    @Inject(method = "onPlayerAction", at = @At("HEAD"), cancellable = true)
    private void onStartBreaking(PlayerActionC2SPacket packet, CallbackInfo ci) {
        PlayerActionC2SPacket.Action myAction = packet.getAction();

        if (GetServerInfo.isState() &
                player.getMainHandStack().toString().split(" ")[1].equals("feather") &
                myAction == START_DESTROY_BLOCK) {
            Logger LOGGER = LoggerFactory.getLogger("CbCp");

            LOGGER.info("LeftClick {} {} {} {} {} {} {} {}",
                    player.getUuid(),
                    packet.getPos().getX(), packet.getPos().getY(), packet.getPos().getZ(),
                    player.getWorld().getRegistryKey().getValue(),
                    player.getPos().getX(), player.getPos().getY(), player.getPos().getZ());

            String requestInfo = "坐标点1：" +
                    packet.getPos().getX() + " " +
                    packet.getPos().getY() + " " +
                    packet.getPos().getZ() + " " +
                    "已记录";

            player.sendMessage(Text.literal(requestInfo));

            ci.cancel();
        }
    }
}
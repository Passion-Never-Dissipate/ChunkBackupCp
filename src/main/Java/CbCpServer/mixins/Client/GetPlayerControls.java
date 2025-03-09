package CbCpServer.mixins.Client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;

@Environment(EnvType.CLIENT)
@Mixin(BlockColors.class)
public class GetPlayerControls {
//    @Inject(
//            method = "handleInputEvents",
//            at = @At("HEAD")
//    )
//    private void onHandleInput(CallbackInfo ci) {
//        MinecraftClient client = (MinecraftClient) (Object) this;
//        if (client.player == null) return;
//
//        // 检测左键按下
//        if (client.options.attackKey.wasPressed()) {
//            HitResult hit = client.player.raycast(5.0F, 0.0F, false);
//            if (hit.getType() == HitResult.Type.BLOCK) {
//                BlockPos pos = ((BlockHitResult) hit).getBlockPos();
//                BlockState state = client.world.getBlockState(pos);
//                client.player.sendMessage(Text.literal("左键按下: " + state.getBlock().getName()), false);
//            }
//        }
//
//        // 检测右键按下
//        if (client.options.useKey.wasPressed()) {
//            HitResult hit = client.player.raycast(5.0F, 0.0F, false);
//            if (hit.getType() == HitResult.Type.BLOCK) {
//                BlockPos pos = ((BlockHitResult) hit).getBlockPos();
//                BlockState state = client.world.getBlockState(pos);
//                client.player.sendMessage(Text.literal("右键按下: " + state.getBlock().getName()), false);
//            }
//        }
//    }
}

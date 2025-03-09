package CbCpServer.mixins.Client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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

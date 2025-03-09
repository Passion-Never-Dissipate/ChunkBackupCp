//package CbCpServer.mixins.Client;
//
//import net.minecraft.client.network.ClientPlayerInteractionManager;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(ClientPlayerInteractionManager.class)
//public class LeftClicks {
//
//    @Inject(method = "attackBlock", at = @At("RETURN"))
//    private void onLeftClicks(BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir){
//
//    }
//}

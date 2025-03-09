package client;

import net.minecraft.util.math.BlockPos;

public class PlayerSettings {
    private static BlockPos LeftClicks;
    private static BlockPos RightClicks;
    private static String world;


    public static BlockPos getRightClicks() {
        return RightClicks;
    }

    public static void setRightClicks(BlockPos rightClicks) {
        RightClicks = rightClicks;
    }

    public static BlockPos getLeftClicks() {
        return LeftClicks;
    }

    public static void setLeftClicks(BlockPos leftClicks) {
        LeftClicks = leftClicks;
    }

    public static String getWorld() {
        return world;
    }

    public static void setWorld(String world) {
        PlayerSettings.world = world;
    }
}

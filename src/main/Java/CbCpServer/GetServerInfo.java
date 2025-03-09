package CbCpServer;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;

public class GetServerInfo {

    private static boolean State;
    private static CommandDispatcher<ServerCommandSource> dispatcher;
    private static CommandContext<ServerCommandSource> context;

    public static boolean isState() {
        return State;
    }

    public static void setState(boolean state) {
        State = state;
    }

    public static CommandDispatcher<ServerCommandSource> getDispatcher() {
        return dispatcher;
    }

    public static void setDispatcher(CommandDispatcher<ServerCommandSource> dispatcher) {
        GetServerInfo.dispatcher = dispatcher;
    }

    public static CommandContext<ServerCommandSource> getContext() {
        return context;
    }

    public static void setContext(CommandContext<ServerCommandSource> context) {
        GetServerInfo.context = context;
    }
}

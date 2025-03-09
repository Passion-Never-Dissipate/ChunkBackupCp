package CbCpServer;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
/*
public class CbCpServer.CbCpServer implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((
                dispatcher,
                registryAccess,
                environment
        ) -> {
            CommandManager.literal("cp")
                    .then(CommandManager.literal("getPlayerOperate"))
                    .then(CommandManager.argument("bool", StringArgumentType.word())
                            .suggests((context, builder) ->
                                    CommandSource.suggestMatching(new String[]{"true", "false"}, builder))
                            .executes(context -> {
                                String bool = StringArgumentType.getString(context, "bool");
                                ServerCommandSource source = context.getSource();

                                if(bool.equals("true")){
                                    getPlayerOperate.setState(true);
                                }else{
                                    getPlayerOperate.setState(false);
                                }

                            return Command.SINGLE_SUCCESS;
                            }))
            ;
        });
    }
}
*/

public class CbCpServer implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, env) -> {
            // 明确限定服务端环境
            if (env.dedicated) {
                dispatcher.register(
                        CommandManager.literal("cp")
                                .then(CommandManager.literal("getPlayerOperate")
                                        .then(CommandManager.argument("bool", StringArgumentType.word())
                                                .suggests((context, builder) ->
                                                        CommandSource.suggestMatching(new String[]{"true", "false"}, builder))
                                                .executes(context -> {
                                                    ServerCommandSource source = context.getSource();
                                                    String bool = StringArgumentType.getString(context, "bool");
//                                                    GetServerInfo.setContext(context);
//                                                    GetServerInfo.setState(Boolean.parseBoolean(bool));

                                                    if(bool.equals("true")){
                                                        source.sendFeedback(() -> Text.literal("区域选择文件开启成功").formatted(Formatting.GRAY), true);
                                                    }else {
                                                        source.sendFeedback(() -> Text.literal("区域选择文件关闭成功").formatted(Formatting.GRAY), true);
                                                    }

                                                    return Command.SINGLE_SUCCESS;
                                                })
                                        )
                                ));
            }
        });
    }
}
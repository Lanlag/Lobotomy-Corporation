package net.uniego.aida.lobecorp.event.server;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//服务器启动后的操作
public class ServerLifeCycleEventsServerStartedEvent implements ServerLifecycleEvents.ServerStarted {
    @Override
    public void onServerStarted(MinecraftServer server) {
        CommandManager manager = server.getCommandManager();
        ServerCommandSource source = server.getCommandSource();

        for (TeamBadge.LobeCorpTeam team : TeamBadge.LobeCorpTeam.values()) {
            //创建部门
            TeamBadge.executeCommand(manager, source, "team add " + team.getTeamId());
            //设置部门前缀及其颜色
            String command = String.format("team modify %s prefix {\"translate\":\"%s\",\"color\":\"%s\"}",
                    team.getTeamId(), "lobecorp.team." + team.getTeamId(), team.getTeamColor().getName().toLowerCase());

            TeamBadge.executeCommand(manager, source, command);
        }
    }
}

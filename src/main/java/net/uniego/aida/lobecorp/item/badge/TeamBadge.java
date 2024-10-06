package net.uniego.aida.lobecorp.item.badge;

import com.mojang.brigadier.ParseResults;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Formatting;
import net.uniego.aida.lobecorp.access.LobeCorpSlotAccess;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.badge.badges.*;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//脑叶公司部门袖标
public class TeamBadge extends LobeCorpItem implements LobeCorpSlotAccess {
    private final LobeCorpTeam team;

    public TeamBadge(Settings settings, LobeCorpTeam team) {
        super(settings.maxCount(1));
        this.team = team;
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("control_badge"), ControlBadge.CONTROL_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("information_badge"), InformationBadge.INFORMATION_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("security_badge"), SecurityBadge.SECURITY_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("training_badge"), TrainingBadge.TRAINING_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("central_command_badge"), CentralCommandBadge.CENTRAL_COMMAND_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("welfare_badge"), WelfareBadge.WELFARE_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("disciplinary_badge"), DisciplinaryBadge.DISCIPLINARY_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("record_badge"), RecordBadge.RECORD_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("extraction_badge"), ExtractionBadge.EXTRACTION_BADGE);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("architecture_badge"), ArchitectureBadge.ARCHITECTURE_BADGE);
    }

    //执行命令通用法
    public static void executeCommand(CommandManager manager, ServerCommandSource source, String command) {
        ParseResults<ServerCommandSource> parseResults = manager.getDispatcher().parse(command, source.withSilent());//静默
        manager.execute(parseResults, command);
    }

    //同步部门
    public static void syncTeam(ItemStack itemStack, ServerCommandSource source, CommandManager manager, ServerPlayerEntity serverPlayer) {
        if (itemStack.getItem() instanceof TeamBadge teamBadge) {
            executeCommand(manager, source, "team join " + teamBadge.team.getTeamId() + " " + serverPlayer.getName().getString());
        }
    }

    @Override
    public LobeCorpAttributeModifierSlot getLobeCorpSlot() {
        return LobeCorpAttributeModifierSlot.LOBECORP_BADGE;
    }

    //脑叶公司部门
    public enum LobeCorpTeam {
        CONTROL_TEAM("control_team", Formatting.DARK_RED),//控制部
        INFORMATION_TEAM("information_team", Formatting.DARK_PURPLE),//情报部
        SECURITY_TEAM("security_team", Formatting.GREEN),//安保部
        TRAINING_TEAM("training_team", Formatting.GOLD),//培训部
        CENTRAL_COMMAND_TEAM("central_command_team", Formatting.YELLOW),//中央本部
        WELFARE_TEAM("welfare_team", Formatting.BLUE),//福利部
        DISCIPLINARY_TEAM("disciplinary_team", Formatting.RED),//惩戒部
        RECORD_TEAM("record_team", Formatting.DARK_GRAY),//记录部
        EXTRACTION_TEAM("extraction_team", Formatting.BLACK),//研发部
        ARCHITECTURE_TEAM("architecture_team", Formatting.WHITE);//构筑部

        private final String teamId;
        private final Formatting teamColor;

        LobeCorpTeam(String teamId, Formatting teamColor) {
            this.teamId = teamId;
            this.teamColor = teamColor;
        }

        public String getTeamId() {
            return teamId;
        }

        public Formatting getTeamColor() {
            return teamColor;
        }
    }
}

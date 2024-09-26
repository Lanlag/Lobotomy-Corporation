package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//中央本部袖标
public class CentralCommandBadge extends TeamBadge {
    public static final CentralCommandBadge CENTRAL_COMMAND_BADGE = new CentralCommandBadge();

    public CentralCommandBadge() {
        super(new Settings(), LobeCorpTeam.CENTRAL_COMMAND_TEAM);
    }
}

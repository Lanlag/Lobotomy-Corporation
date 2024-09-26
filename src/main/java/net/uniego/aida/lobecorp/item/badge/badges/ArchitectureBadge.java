package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//构筑部袖标
public class ArchitectureBadge extends TeamBadge {
    public static final ArchitectureBadge ARCHITECTURE_BADGE = new ArchitectureBadge();

    public ArchitectureBadge() {
        super(new Settings(), LobeCorpTeam.ARCHITECTURE_TEAM);
    }
}

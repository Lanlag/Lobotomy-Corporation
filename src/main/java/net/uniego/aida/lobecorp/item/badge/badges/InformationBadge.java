package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//情报部袖标
public class InformationBadge extends TeamBadge {
    public static final InformationBadge INFORMATION_BADGE = new InformationBadge();

    public InformationBadge() {
        super(new Settings(), LobeCorpTeam.INFORMATION_TEAM);
    }
}

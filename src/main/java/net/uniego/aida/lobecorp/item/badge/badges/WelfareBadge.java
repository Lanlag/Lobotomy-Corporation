package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//福利部袖标
public class WelfareBadge extends TeamBadge {
    public static final WelfareBadge WELFARE_BADGE = new WelfareBadge();

    public WelfareBadge() {
        super(new Settings(), LobeCorpTeam.WELFARE_TEAM);
    }
}

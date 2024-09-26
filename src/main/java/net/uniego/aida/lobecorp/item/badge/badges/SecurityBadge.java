package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//安保部袖标
public class SecurityBadge extends TeamBadge {
    public static final SecurityBadge SECURITY_BADGE = new SecurityBadge();

    public SecurityBadge() {
        super(new Settings(), LobeCorpTeam.SECURITY_TEAM);
    }
}

package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//控制部袖标
public class ControlBadge extends TeamBadge {
    public static final ControlBadge CONTROL_BADGE = new ControlBadge();

    public ControlBadge() {
        super(new Settings(), LobeCorpTeam.CONTROL_TEAM);
    }
}

package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//惩戒部袖标
public class DisciplinaryBadge extends TeamBadge {
    public static final DisciplinaryBadge DISCIPLINARY_BADGE = new DisciplinaryBadge();

    public DisciplinaryBadge() {
        super(new Settings(), LobeCorpTeam.DISCIPLINARY_TEAM);
    }
}

package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//记录部袖标
public class RecordBadge extends TeamBadge {
    public static final RecordBadge RECORD_BADGE = new RecordBadge();

    public RecordBadge() {
        super(new Settings(), LobeCorpTeam.RECORD_TEAM);
    }
}

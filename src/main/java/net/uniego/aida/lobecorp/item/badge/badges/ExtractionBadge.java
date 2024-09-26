package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//研发部袖标
public class ExtractionBadge extends TeamBadge {
    public static final ExtractionBadge EXTRACTION_BADGE = new ExtractionBadge();

    public ExtractionBadge() {
        super(new Settings(), LobeCorpTeam.EXTRACTION_TEAM);
    }
}

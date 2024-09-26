package net.uniego.aida.lobecorp.item.badge.badges;

import net.uniego.aida.lobecorp.item.badge.TeamBadge;

//培训部袖标
public class TrainingBadge extends TeamBadge {
    public static final TrainingBadge TRAINING_BADGE = new TrainingBadge();

    public TrainingBadge() {
        super(new Settings(), LobeCorpTeam.TRAINING_TEAM);
    }
}

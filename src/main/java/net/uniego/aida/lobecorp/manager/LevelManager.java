package net.uniego.aida.lobecorp.manager;

//等级机制
public class LevelManager {
    private int maxHealth = 0;
    private int maxSanity = 0;
    private int workSuccess = 0;
    private int workVelocity = 0;
    private int attackVelocity = 0;
    private int moveVelocity = 0;
    private LobeCorpLevel levelF = LobeCorpLevel.ER;//勇气Fortitude
    private LobeCorpLevel levelP = LobeCorpLevel.ER;//谨慎Prudence
    private LobeCorpLevel levelT = LobeCorpLevel.ER;//自律Temperance
    private LobeCorpLevel levelJ = LobeCorpLevel.ER;//正义Justice
    private LobeCorpLevel totalLevel = LobeCorpLevel.ER;//总等级

    public LevelManager() {
    }

    //等级计算公式
    public static LobeCorpLevel calculateLevel(int levelValue) {
        if (levelValue > 0 && levelValue < 30) {
            return LobeCorpLevel.I;
        } else if (levelValue >= 30 && levelValue < 45) {
            return LobeCorpLevel.II;
        } else if (levelValue >= 45 && levelValue < 65) {
            return LobeCorpLevel.III;
        } else if (levelValue >= 65 && levelValue < 85) {
            return LobeCorpLevel.IV;
        } else if (levelValue >= 85 && levelValue < 100) {
            return LobeCorpLevel.V;
        } else {
            return levelValue >= 100 ? LobeCorpLevel.EX : LobeCorpLevel.ER;
        }
    }

    //总等级计算公式
    public static LobeCorpLevel calculateTotalLevel(LobeCorpLevel levelF, LobeCorpLevel levelP, LobeCorpLevel levelT, LobeCorpLevel levelJ) {
        int result = Math.max(1, Math.min(6, (levelF.getValue() + levelP.getValue() + levelT.getValue() + levelJ.getValue()) / 3));
        LobeCorpLevel totalLevel;
        switch (result) {
            case 1 -> totalLevel = LobeCorpLevel.I;
            case 2 -> totalLevel = LobeCorpLevel.II;
            case 3 -> totalLevel = LobeCorpLevel.III;
            case 4 -> totalLevel = LobeCorpLevel.IV;
            case 5 -> totalLevel = LobeCorpLevel.V;
            case 6 -> totalLevel = LobeCorpLevel.EX;
            default -> totalLevel = LobeCorpLevel.ER;
        }
        return totalLevel;
    }

    public void update(double maxHealth, double maxSanity, double workSuccess, double workVelocity, double attackVelocity, double moveVelocity) {
        //获取参数
        this.maxHealth = (int) maxHealth;
        this.maxSanity = (int) maxSanity;
        this.workSuccess = (int) workSuccess;
        this.workVelocity = (int) workVelocity;
        this.attackVelocity = (int) attackVelocity;
        this.moveVelocity = (int) moveVelocity;
        //计算等级
        levelF = calculateLevel((int) maxHealth);
        levelP = calculateLevel((int) maxSanity);
        levelT = calculateLevel((int) ((workSuccess + workVelocity) / 2));
        levelJ = calculateLevel((int) ((attackVelocity + moveVelocity) / 2));
        totalLevel = calculateTotalLevel(levelF, levelP, levelT, levelJ);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxSanity() {
        return maxSanity;
    }

    public int getWorkSuccess() {
        return workSuccess;
    }

    public int getWorkVelocity() {
        return workVelocity;
    }

    public int getAttackVelocity() {
        return attackVelocity;
    }

    public int getMoveVelocity() {
        return moveVelocity;
    }

    public LobeCorpLevel getLevelF() {
        return levelF;
    }

    public LobeCorpLevel getLevelP() {
        return levelP;
    }

    public LobeCorpLevel getLevelT() {
        return levelT;
    }

    public LobeCorpLevel getLevelJ() {
        return levelJ;
    }

    public LobeCorpLevel getTotalLevel() {
        return totalLevel;
    }

    //脑叶公司等级
    public enum LobeCorpLevel {
        I("I", 1),
        II("II", 2),
        III("III", 3),
        IV("IV", 4),
        V("V", 5),
        EX("EX", 6),
        ER("ER", -1);

        private final String level;
        private final int value;

        LobeCorpLevel(String level, int value) {
            this.level = level;
            this.value = value;
        }

        public String getLevel() {
            return level;
        }

        public int getValue() {
            return value;
        }
    }
}

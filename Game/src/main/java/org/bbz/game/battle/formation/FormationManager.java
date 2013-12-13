package org.bbz.game.battle.formation;

import org.bbz.game.battle.fighter.IFighter;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-5
 * Time: 上午10:24
 */
public class FormationManager {

    private FormationData formationData;

    /**
     * 主阵容
     */
    private IFormation main;

    /**
     * 替补阵容
     */
    private IFormation alternate;

    public boolean move(IFighter sourceFighter, int targetPos) {
        if (targetPos == -1) {
            formationData.remove(sourceFighter);
        }

        return false;
    }


    boolean checkMove(IFighter sourceFighter, int targetPos) {
        return true;
    }

}

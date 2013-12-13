package org.bbz.game.battle.formation;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.bbz.game.battle.fighter.IFighter;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-5
 * Time: 下午3:24
 */
public class FormationData {
    public static final int NO_POSITION = -1;

    private BiMap<Integer, IFighter> positionMap = HashBiMap.create();

    public FormationData(Map<Integer, IFighter> positionMap) {
        for (Map.Entry<Integer, IFighter> entry : positionMap.entrySet()) {
            this.positionMap.put(entry.getKey(), entry.getValue());
        }
    }


    /**
     * 仅仅是下阵
     *
     * @param sourceFighter
     */
    public void remove(IFighter sourceFighter) {
        positionMap.remove(sourceFighter);
    }

    /**
     * 两个阵上的位置上的战士交换位置
     *
     * @param src
     * @param des
     */
    void exchange(int src, int des) {
        IFighter srcFighter = positionMap.get(src);
        IFighter desFighter = positionMap.get(des);

        put(src, desFighter);
        put(des, srcFighter);

    }

    /**
     * 仅仅上阵
     *
     * @param sourceFighter
     * @param des
     */
    boolean add(IFighter sourceFighter, int des) {
        if (checkAdd(des)) {
            positionMap.put(des, sourceFighter);
            return true;
        }
        return false;
    }

    private boolean checkAdd(int des) {

        return false;
    }

    private void put(int pos, IFighter fighter) {
        if (pos == NO_POSITION) {

        }
        if (fighter == null) {
            positionMap.remove(pos);

        }
        positionMap.put(pos, fighter);
    }


}

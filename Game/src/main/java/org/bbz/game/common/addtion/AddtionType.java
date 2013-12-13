package org.bbz.game.common.addtion;

import com.google.common.collect.Maps;
import org.bbz.game.battle.fighter.IFighter;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-10
 * Time: 上午11:18
 */
public enum AddtionType {
    /**
     * 物理攻击力
     */
    PATTACK(1) {
        @Override
        public void calcAddtion(IFighter fighter, AddtionData addtionData) {
            fighter.addPAttack(addtionData);
        }
    },;

    private int number;

    private static final Map<Integer, AddtionType> numToEnum = Maps.newHashMap();

    static {
        for (AddtionType t : values()) {

            AddtionType s = numToEnum.put(t.number, t);
            if (s != null) {
                throw new RuntimeException(t.number + "重复了");
            }
        }
    }

    AddtionType(int number) {
        this.number = number;
    }

    public int toNum() {
        return number;
    }

    public static AddtionType fromNum(int n) {
        return numToEnum.get(n);
    }

    public abstract void calcAddtion(IFighter fighter, AddtionData addtionData);
}

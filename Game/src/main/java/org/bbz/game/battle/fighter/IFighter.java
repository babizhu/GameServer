package org.bbz.game.battle.fighter;

import org.bbz.game.common.addtion.AddtionData;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-5
 * Time: 上午10:29
 */
public interface IFighter {

    public int getPosition();

    public int getHpMax();

    /**
     * 获取物理攻击力
     *
     * @return
     */
    public int getPAttack();


    void addPAttack(AddtionData addtionData);
}

package org.bbz.game.battle.fighter;

import org.bbz.game.common.addtion.AddtionData;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-10
 * Time: 上午11:35
 * <p/>
 * 各种加成
 */
public interface IAddtionable {
    /**
     * 添加加成
     *
     * @param addtionData
     */
    void addAddtion(AddtionData addtionData);

    /**
     * 删除加成
     *
     * @param addtionData
     */
    void removeAddtion(AddtionData addtionData);

}

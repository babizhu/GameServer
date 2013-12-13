package org.bbz.game.battle.fighter;

import com.google.common.collect.Lists;
import org.bbz.game.common.addtion.AddtionData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-10
 * Time: 上午11:46
 */
public class AbstractFighter implements IFighter, IAddtionable {

    /**
     * 所有的加成内容
     */
    List<AddtionData> addtionDataList = Lists.newArrayList();


    @Override
    public int getPosition() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHpMax() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getPAttack() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addPAttack(AddtionData addtionData) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addAddtion(AddtionData addtionData) {
        addtionDataList.add(addtionData);
        addtionData.getType().calcAddtion(this, addtionData);
    }

    @Override
    public void removeAddtion(AddtionData addtionData) {
        addtionDataList.remove(addtionData);
        addtionData.getType().calcAddtion(this, addtionData);
    }

    /**
     * 计算所有的加成
     */
    private final void calcAddtion() {
        for (AddtionData addtionData : addtionDataList) {
            addtionData.getType().calcAddtion(this, addtionData);
        }
    }
}

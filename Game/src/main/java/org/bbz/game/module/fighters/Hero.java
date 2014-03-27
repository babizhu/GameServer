package org.bbz.game.module.fighters;

import com.google.common.collect.Sets;
import lombok.Data;
import org.bbz.game.module.equipments.Equipment;
import org.bbz.util.db.IdentityObj;

import java.util.Set;

/**
 * user         LIUKUN
 * time         14-3-25 下午1:36
 * 玩家手中的英雄
 */

@Data
public class Hero extends Fighter implements IdentityObj{

    /**
     * 唯一标识
     */
    private int id;

    /**
     * 名字
     */
    private String name;
    /**
     * 装备
     */
    private Set<Equipment> equipments = Sets.newHashSet();

    /**
     * 所在位置
     * 0表示不在战斗位置上，处于闲置状态
     */
    private int position;

    /**
     * 经验
     */
    private int exp;

    /**
     * 升级
     */
    public void levelUp(){

    }
}

package org.bbz.game.module.fighters;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.ToString;
import org.bbz.game.module.equipments.Equipment;

import java.util.Set;

/**
 * user         LIUKUN
 * time         14-3-25 下午1:44
 */
@Data
@ToString
public class HeroDto{
    private Set<Integer> equipmentId = Sets.newHashSet();
    private String name;
    private int position;

    /**
     * 缺省构造函数，反序列化的时候使用
     */
    public HeroDto(){
    }

    public HeroDto( Hero hero ){
        for( Equipment equipment : hero.getEquipments() ) {
            equipmentId.add( equipment.getId() );
        }
        this.name = hero.getName();
        position = hero.getPosition();

    }


}

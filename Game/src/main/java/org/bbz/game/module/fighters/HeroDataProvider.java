package org.bbz.game.module.fighters;

import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bbz.game.cfg.fighter.FighterTemplet;
import org.bbz.game.cfg.fighter.FighterTempletCfg;
import org.bbz.game.module.equipments.Equipment;
import org.bbz.util.common.TransForm;
import org.bbz.util.db.AbstractDataProviderWithIdentity;

import java.util.Set;

/**
 * user         LIUKUN
 * time         14-3-26 下午2:38
 */

public class HeroDataProvider extends AbstractDataProviderWithIdentity<Hero>{

    private static final String TABLE_NAME = "hero";

    public HeroDataProvider( String uname ){
        super( TABLE_NAME, uname );
    }

    @Override
    protected Hero decode( DBObject object ){
        Hero hero = new Hero( (int) object.get( "_id" ) );
        hero.setName( (String) object.get( "name" ) );
        Set<Equipment> equipments = Sets.newHashSet();
        int[] arr = TransForm.ArrayType.toInt( (String) object.get( "equipmentS" ) );
        for( int id : arr ) {
            Equipment e = new Equipment();
            e.setId( id );
            equipments.add( e );
        }

        hero.setEquipments( equipments );
        hero.setPosition( (int) object.get( "position" ) );
        int templetId = (int) object.get( "templetId" );
        FighterTemplet templet = FighterTempletCfg.getFighterTempletById( templetId );
        hero.setTemplet( templet );
        return hero;
    }


    @Override
    protected DBObject encode( Hero hero ){
        DBObject obj = new BasicDBObject();
        obj.put( "_id", hero.getId() );
        obj.put( "uname", getUname() );
        obj.put( "name", hero.getName() );
        obj.put( "position", hero.getPosition() );
        String equipmentStr = "";
        for( Equipment e : hero.getEquipments() ) {
            equipmentStr += e.getId();
            equipmentStr += ",";
        }
        obj.put( "equipmentS", equipmentStr );
        obj.put( "templetId", hero.getTemplet().getId() );
        return obj;
    }

}
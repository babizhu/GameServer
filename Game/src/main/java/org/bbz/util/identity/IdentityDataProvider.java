package org.bbz.util.identity;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import util.db.MongoUtil;

/**
 * user         LIUKUN
 * time         2014-3-28 17:19
 */

public enum IdentityDataProvider{
    INSTANCE;

    private final String TABLE_NAME = "global_identity";
    private final int ID_FIELD = "global_identity";
    private DBCollection collection = MongoUtil.INSTANCE.getDB().getCollection( TABLE_NAME );
    
    public long get(){
        DBObject object = collection.findOne();
        if( object == null ){
            return  0;
        }
        return (long) object.get( "id" );
    }
    
    public void set( long id ){
        DBObject obj = new BasicDBObject( "id", id ).append( "_id", );
        collection.save( obj )
    }
}

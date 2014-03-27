package org.bbz.util.db;

import com.google.common.collect.Lists;
import com.mongodb.*;
import util.db.MongoUtil;

import java.util.List;

/**
 * user         LIUKUN
 * time         14-3-27 下午3:51
 * <p/>
 * 负责处理具有唯一id的实体类
 */

public abstract class AbstractDataProviderWithIdentity<T extends IdentityObj>{
    private final String uname;
    private final DBCollection collection;

    public AbstractDataProviderWithIdentity( String tableName, String uname ){
        this.uname = uname;
        collection = MongoUtil.INSTANCE.getDB().getCollection( tableName );
    }

//    public IdentityObj findOne( DBObject conditon ){
//        return decode( collection.findOne( conditon ) );
//    }

//    public List<IdentityObj> findBy( String key, String content ){
//        return null;
//    }

    public void add( T t ){
        collection.insert( encode( t ) );
    }

    public List<T> getAll(){
        List<T> list = Lists.newArrayList();

        BasicDBObject condition = new BasicDBObject();
        condition.put( "uname", uname );

        DBCursor cursor = collection.find( condition );

        while( cursor.hasNext() ) {
//            cursor.next();
            list.add( decode( cursor.next() ) );
        }
        return list;
    }

    protected abstract T decode( DBObject object );

    protected abstract DBObject encode( T t );

    public void remove( int id ){
        DBObject conditon = new BasicDBObject();
        conditon.put( "_id", id );

        collection.remove( conditon );
    }

    public void update( T t ){
        DBObject conditon = new BasicDBObject();
        conditon.put( "_id", t.getId() );

        collection.update( conditon, encode( t ) );
    }

    public void removeAll(){
        DBObject conditon = new BasicDBObject();
        conditon.put( "uname", uname );
        collection.remove( conditon );
    }

    /**
     * 如果数据库存在此数据，则更新此数据，否则添加此数据
     *
     * @param t 要更新的数据
     * @return true:替换         false:插入
     */
    public boolean replace( T t ){
        WriteResult save = collection.save( encode( t ) );
        return (boolean) save.getField( "updatedExisting" );
    }

    public String getUname(){
        return uname;
    }

    public DBCollection getCollection(){
        return collection;
    }
}

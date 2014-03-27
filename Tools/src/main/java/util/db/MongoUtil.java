package util.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * user         LIUKUN
 * time         14-3-25 下午7:47
 */

public enum MongoUtil{
    INSTANCE;

    private MongoClient client;
    private DB db;

    MongoUtil(){
        ResourceBundle bundle = ResourceBundle.getBundle( "mongo" );
        if( bundle == null ) {
            throw new IllegalArgumentException(
                    "[mongo.properties] is not found!" );
        }
        String ip = bundle.getString( "ip" );
        int port = Integer.parseInt( bundle.getString( "port" ) );
        String dbName = bundle.getString( "dbName" );
        ServerAddress serverAddress = null;
        try {
            serverAddress = new ServerAddress( ip, port );
        } catch( UnknownHostException e ) {
            e.printStackTrace();
        }

        client = new MongoClient( serverAddress );
        db = client.getDB( dbName );

    }

    public DB getDB(){
        return db;
    }

}

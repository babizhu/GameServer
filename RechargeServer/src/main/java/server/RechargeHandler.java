package server;

import org.xsocket.connection.*;
import util.DataTransform;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * 充值
 * Created by Administrator on 14-3-6.
 */
public class RechargeHandler implements IDataHandler, IConnectHandler, IIdleTimeoutHandler, IConnectionTimeoutHandler, IDisconnectHandler{

    @Override
    public boolean onConnect(INonBlockingConnection con) throws IOException, BufferUnderflowException{
//        System.out.println( con.getRemoteAddress() + "onConnect" );
        return false;
    }

    @Override
    public boolean onConnectionTimeout(INonBlockingConnection con) throws IOException{
//        System.out.println( con.getRemoteAddress() + "onConnectionTimeout" );
        return false;
    }

    @Override
    public boolean onData(INonBlockingConnection con) throws IOException{

        con = ConnectionUtils.synchronizedConnection(con);
        int totalLength = 0;//ReceiveBuf.getUnsignedShort();
        short packageVersion = 0;//ReceiveBuf.getUnsigned();
        short remainPackages = 0;//ReceiveBuf.getUnsigned();
        long ReceiveComand = 0;//ReceiveBuf.getUnsignedInt();
        long sequenceId = 0;
        long gameId = 0;
        long gatewayId = 0;

        con.markReadPosition();

        try {
            totalLength = DataTransform.getUnsignedShort(con.readShort());
            packageVersion = DataTransform.getUnsigned(con.readByte());
            remainPackages = DataTransform.getUnsigned(con.readByte());
            ReceiveComand = DataTransform.getUnsignedInt(con.readInt());
            sequenceId = DataTransform.getUnsignedInt(con.readInt());
            gameId = DataTransform.getUnsignedInt(con.readInt());
            gatewayId = DataTransform.getUnsignedInt(con.readInt());

            byte[] body = con.readBytesByLength(totalLength - 20 - 4);// 4 for checksum no use


            con.removeReadMark();

        } catch( BufferUnderflowException bue ) {
            con.resetToReadMark();
            return true;
        }

        return true;
    }

    @Override
    public boolean onDisconnect(INonBlockingConnection con) throws IOException{
//        System.out.println( con.getRemoteAddress() + "onDisconnect" );
        return false;
    }

    @Override
    public boolean onIdleTimeout(INonBlockingConnection con) throws IOException{
//        System.out.println( con.getRemoteAddress() + "onIdleTimeout" );
        return false;
    }
}
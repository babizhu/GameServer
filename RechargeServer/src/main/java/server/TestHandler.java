package server;

import org.xsocket.MaxReadSizeExceededException;
import org.xsocket.connection.*;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 14-3-14.
 */
public class TestHandler implements IDataHandler, IConnectHandler, IIdleTimeoutHandler, IConnectionTimeoutHandler, IDisconnectHandler{
    @Override
    public boolean onConnect(INonBlockingConnection connection) throws IOException, BufferUnderflowException, MaxReadSizeExceededException{
        System.out.println(connection.getRemoteAddress() + " : " + connection.getRemotePort() + " 连接了");
        return false;
    }

    @Override
    public boolean onConnectionTimeout(INonBlockingConnection connection) throws IOException{
        return false;
    }

    @Override
    public boolean onData(INonBlockingConnection connection) throws IOException{
        int len;
        int cmd;
        byte[] body = null;
        connection.markReadPosition();
        System.out.println("available = " + connection.available());
        try {
            len = connection.readInt();
//            System.out.println( "len = " + len );
            cmd = connection.readInt();
//            System.out.println( "cmd = " + cmd );

            body = connection.readBytesByLength(5);
            connection.removeReadMark();

        } catch( BufferUnderflowException bul ) {
            connection.resetToReadMark();
            return true;
        }


        ByteBuffer data = ByteBuffer.wrap(body);
        test(data);


        return true;
    }

    private void test(ByteBuffer data){
        try {
            System.out.println(2222);
            int i = data.getInt();
            System.out.println(1111);
            int j = data.getInt();
            System.out.println(333);

            System.out.println("i = " + i + "j = " + j);
        } catch( Exception e ) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onDisconnect(INonBlockingConnection connection) throws IOException{
        System.out.println(connection + " is Disconnect");
        return false;
    }

    @Override
    public boolean onIdleTimeout(INonBlockingConnection connection) throws IOException{
        return false;
    }
}

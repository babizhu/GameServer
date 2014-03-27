package command.service;

import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * Created by Administrator on 14-3-11.
 */
public enum ServiceDispatch{
    INSTANCE;

    void dispatch( int cmd ) throws IOException{


        Object ret = null;
        switch( cmd ) {
            case 1:
                ret = RechargeServiceImpl.INSTANCE.getData();
                break;
            case 2:
                ret = RechargeServiceImpl.INSTANCE.getName();
        }
        MessagePack msgpack = new MessagePack();
        byte[] write = msgpack.write( ret );

    }
}

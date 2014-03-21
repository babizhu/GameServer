package command.service;

import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * Created by Administrator on 14-3-11.
 */
public class ServiceDispatch{

    void dispatch(int cmd) throws IOException{
        Object ret = null;
        switch( cmd ) {
            case 1:
                ret = RechargeServiceImpl.INSTANCE.getData();
                break;
        }
        MessagePack msgpack = new MessagePack();
        byte[] write = msgpack.write(ret);

    }
}

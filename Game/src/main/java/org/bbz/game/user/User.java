package org.bbz.game.user;

import lombok.Data;
import org.msgpack.annotation.Message;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */

@Data
@Message
public class User{
    private String name;


}

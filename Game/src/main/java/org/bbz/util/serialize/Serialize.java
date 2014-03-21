package org.bbz.util.serialize;

import org.bbz.game.user.User;
import org.bbz.util.serialize.impl.FastJsonImpl;

/**
 * Created with IntelliJ IDEA.
 * User: liukun
 * Date: 13-11-17
 * Time: 下午4:50
 */
public class Serialize{
    public static ISerialize getInstance(){
        return serialize;
    }

    //    private static final ISerialize serialize = new MsgPackImpl();
    private static final ISerialize serialize = new FastJsonImpl();

    private Serialize(){
    }

    public static void main( String[] args ){
        User user = new User();
        user.setName("lk");

        Object o = user;

        byte[] encode = Serialize.getInstance().encode(o);
        System.out.println(encode.length);


        User u = Serialize.getInstance().decode(encode, User.class);
        System.out.println(u.getName());

    }
}

package org.bbz.util.serialize;

import org.bbz.util.serialize.impl.MsgPackImpl;

/**
 * Created with IntelliJ IDEA.
 * User: liukun
 * Date: 13-11-17
 * Time: 下午4:50
 */
public class Serialize {
    public static ISerialize getInstance() {
        return serialize;
    }

    private static final ISerialize serialize = new MsgPackImpl();

    private Serialize() {
    }

    public static void main(String[] args) {
        Serialize.getInstance().encode("A");
    }
}

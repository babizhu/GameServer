package org.bbz.util.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-1-21.
 */
public enum CounterKey {
    PATTACK(1),;

    private final int number;

    private static final Map<Integer, CounterKey> numToEnum = new HashMap<Integer, CounterKey>();

    static {
        for (CounterKey t : values()) {

            CounterKey s = numToEnum.put(t.number, t);
            if (s != null) {
                throw new RuntimeException(t.number + "重复了");
            }
        }
    }

    CounterKey(int number) {
        this.number = number;
    }

    public int toNum() {
        return number;
    }

    public static CounterKey fromNum(int n) {
        return numToEnum.get(n);
    }
}

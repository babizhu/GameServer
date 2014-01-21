package org.bbz.util.common;

import com.google.common.collect.Maps;
import org.bbz.game.user.User;

import java.util.Map;

/**
 * 计数器，用来统计各种每日数据，例如今日闯关次数，今日免费挑战次数等<br/>
 * 到0点会自动清除
 * Created by Administrator on 14-1-21.
 */
public class CounterPerDay {
    Map<CounterKey, Integer> data = Maps.newEnumMap(CounterKey.class);
    private final User user;
    private int today;

    public CounterPerDay(User user) {
        this.user = user;

    }

    public int get(CounterKey key) {

        return 0;
    }

    public void set(CounterKey key) {

    }

    public void add(CounterKey key, int change) {

        int value = 0;
        if (data.containsKey(key)) {
            value = data.get(key);
        }
        value += change;
        data.put(key, value);

    }


    public static void main(String[] args) {
        CounterPerDay c = new CounterPerDay(null);
        c.add(null, 20);
    }
}

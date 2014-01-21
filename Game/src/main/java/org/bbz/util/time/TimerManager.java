package org.bbz.util.time;

import com.google.common.eventbus.EventBus;

import java.util.Objects;

/**
 * 计时器管理器，用于进行计时器的管理，例如12点执行等
 * 到时间之后发出一个事件即可
 * Created by Administrator on 14-1-21.
 */
public enum TimerManager {
    INSTANCE;

    private EventBus channle;

    /**
     * 注册事件
     *
     * @param obj
     */
    void addListener(Objects obj) {
        channle.register(obj);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = sb;
        System.out.println(sb1);
        sb = null;
        System.out.println(sb1);


    }
}

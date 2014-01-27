package org.bbz.util.time;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 计时器管理器，用于进行计时器的管理，例如12点执行等
 * 到时间之后发出一个事件即可
 * Created by Administrator on 14-1-21.
 */
public enum TimerManager {
    INSTANCE;

    private static final int TICK_UNIT = 1;
    private EventBus channle = new EventBus();
    private final ScheduledExecutorService s = Executors.newScheduledThreadPool(1);

    TimerManager(){
        s.scheduleAtFixedRate(new TimerTicker(), TICK_UNIT, TICK_UNIT, TimeUnit.SECONDS);
        s.scheduleAtFixedRate(new TimerTicker1(), 2, 0, TimeUnit.SECONDS);
    }

    private class TimerTicker implements Runnable{

        int i = 0;

        @Override
        public void run(){
//            LocalTime time = new LocalTime();
//            LocalTime mark = new LocalTime(13,30,0);
//            if( time.equals( mark ) )
            {
                //System.out.println( time );
                //channle.post( new ZeroClockEvent() );
                System.out.println(Thread.currentThread() + "TimerTicker run");
            }
        }

    }

    private class TimerTicker1 implements Runnable{

        int i = 0;

        @Override
        public void run(){
            System.out.println(Thread.currentThread() + "TimerTicker1 run");
        }

    }

    /**
     * 注册事件
     *
     * @param obj       要侦听的对象
     */
    public void register(ITimerTask obj){
        channle.register(obj);
    }

    /**
     * 卸载事件
     *
     * @param obj 要卸载的对象
     */
    public void unregister(Object obj){
        channle.unregister(obj);
    }

    public static void main(String[] args){

    }
}

package org.bbz.util.time;

import com.google.common.eventbus.Subscribe;
import org.bbz.util.time.events.ZeroClockEvent;

/**
 * Created by Administrator on 14-1-22.
 */
public class EventTest implements ITimerTask{

    @Subscribe
    public void doSomething(ZeroClockEvent event){
        System.out.println(Thread.currentThread());
        System.out.println("12点到了，随便做点什么！");
    }

    public static void main(String[] args) throws InterruptedException{
        EventTest t = new EventTest();

        TimerManager.INSTANCE.register(t);
    }

    @Override
    public int getNextRunTime(){

        return 0;
    }

    @Override
    public int getLoop(){
        return 0;
    }
}

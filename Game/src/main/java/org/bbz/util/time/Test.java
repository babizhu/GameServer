package org.bbz.util.time;

/**
 * Created by Administrator on 14-1-27.
 */
public class Test{
    public static void main(String[] argv){
        final Timer timer = new HashedWheelTimer();
        timer.newTimeout(new TimerTask(){
            public void run(Timeout timeout) throws Exception{
                System.out.println("timeout 5");
            }
        }, 5, TimeUnit.SECONDS);
        timer.newTimeout(new TimerTask(){
            public void run(Timeout timeout) throws Exception{
                System.out.println("timeout 10");
            }
        }, 10, TimeUnit.SECONDS);
    }
}

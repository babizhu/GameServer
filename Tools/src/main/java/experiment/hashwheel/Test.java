package experiment.hashwheel;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 14-1-28.
 */

class Task1 implements ITimerTask{

    @Override
    public void run(ITimeout timeout) throws Exception{
        System.out.println(new DateTime().toLocalTime());

    }
}

public class Test{
    public static void main(String[] args){
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();
        System.out.println(new LocalTime());
        hashedWheelTimer.newTimeout(new Task1(), 1, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(new Task1(), 2, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(new Task1(), 5, TimeUnit.SECONDS);


    }
}

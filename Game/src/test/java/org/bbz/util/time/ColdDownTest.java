package org.bbz.util.time;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Administrator on 14-2-13.
 */
public class ColdDownTest{
    int coldSec = 4;

    @Test
    public void testGetRemainSec() throws Exception{
        int endSec = SystemTimer.currentTimeSecond() + coldSec;
        IColdDown coldDown = new ColdDown(endSec);
        int sleepSec = 3;
        Thread.sleep(sleepSec * 1000);
        assertEquals(coldSec - sleepSec, coldDown.getRemainSec());
    }

    @Test
    public void testExpire() throws Exception{

        int endSec = SystemTimer.currentTimeSecond() + coldSec;
        IColdDown coldDown = new ColdDown(endSec);
        int sleepSec = 3;
        Thread.sleep(sleepSec * 1000);
        assertEquals(false, coldDown.expire());//尚未结束

        Thread.sleep(sleepSec * 1000);
        assertEquals(true, coldDown.expire());//再睡一秒后就结束了
    }

    @Test
    public void testGetEndTime() throws Exception{
        int endSec = SystemTimer.currentTimeSecond() + coldSec;
        IColdDown coldDown = new ColdDown(endSec);
        assertEquals(endSec, coldDown.getEndTime());
    }

    @Test
    public void testMain() throws Exception{

    }
}

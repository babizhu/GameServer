package org.bbz.util.common;

import org.bbz.util.D;
import org.bbz.util.time.SystemTimer;
import org.bbz.util.time.TimeUtil;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Administrator on 14-1-22.
 */
public class TimeUtilTest{
    @Test
    public void testIsToday() throws Exception{
        LocalDate date = new LocalDate();
        int time = (int) (date.toDate().getTime() / 1000);

        assertEquals(true, TimeUtil.isToday(time));

        date = new LocalDate(2002, 4, 3);
        time = (int) (date.toDate().getTime() / 1000);
        assertEquals(false, TimeUtil.isToday(time));

        Date date1 = date.toDate();
        System.out.println(date1);

        LocalDate.Property property = date.centuryOfEra();
        System.out.println(date + "是一年的第" + date.weekOfWeekyear().get() + "个礼拜");
        System.out.println(property.get());
    }

    @Test
    public void testCreateBySecond() throws Exception{
        DateTime date = TimeUtil.createBySecond(SystemTimer.currentTimeSecond());
        System.out.println("当前时间:" + date.toString(D.DATETIME_PATTERN));
    }
}

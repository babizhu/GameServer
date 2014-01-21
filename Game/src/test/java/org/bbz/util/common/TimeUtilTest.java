package org.bbz.util.common;

import org.joda.time.LocalDate;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Administrator on 14-1-21.
 */
public class TimeUtilTest {
    @Test
    public void testisToday() {
        LocalDate date = new LocalDate();
        int time = (int) (date.toDate().getTime() / 1000);

        assertEquals(true, TimeUtil.isToday(time));

        date = new LocalDate(2002, 4, 3);
        time = (int) (date.toDate().getTime() / 1000);
        assertEquals(false, TimeUtil.isToday(time));
    }
}
